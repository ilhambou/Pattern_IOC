import Metier.IB_SalaireMetier;
import Metier.IB_IMetier;
import Modele.IB_Salaire;
import dao.IB_SalaireDao;
import dao.IB_IDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.IB_SalaireControleur;
import presentation.IB_IControleur;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class IB_Simulateur {


        static Scanner clavier = new Scanner(System.in);
        static IB_IControleur salaireControleur;//test2

        public static void test2() throws Exception
        {
            String daoClass;
            String serviceClass;
            String controllerClass;

            Properties properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream propertiesFile = classLoader.getResourceAsStream("config.properties");
            if(propertiesFile == null) throw new Exception("fichier config introuvable");
            else {
                try {
                    properties.load(propertiesFile);
                    daoClass = properties.getProperty("DAO");
                    serviceClass = properties.getProperty("SERVICE");
                    controllerClass = properties.getProperty("CONTROLLER");
                    propertiesFile.close();
                }catch (IOException e)
                {
                    throw new Exception("probleme au niveau du fichier");

                }finally {
                    properties.clear();
                }
                try {
                    Class cDao = Class.forName(daoClass);
                    Class cMetier = Class.forName(serviceClass);
                    Class cControleur = Class.forName(controllerClass);
                    var dao = (IB_IDao<IB_Salaire, Long>)cDao.getDeclaredConstructor().newInstance();
                    var metier = (IB_IMetier) cMetier.getDeclaredConstructor().newInstance();
                    var salaireControleur = (IB_IControleur) cControleur.getDeclaredConstructor().newInstance();



                    Method setDao = cMetier.getMethod("setSalaireDao", IB_IDao.class);
                    setDao.invoke(metier, dao);

                    Method setMetier = cControleur.getMethod("setSalaireMetier", IB_IMetier.class);
                    setMetier.invoke(salaireControleur, metier);

                    salaireControleur.afficher_SalaireNet(1L);



                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        }



        private static boolean estUnNombre(String input)
        {
            try
            {
                Integer.parseInt(input);
                return true;
            }catch (Exception e)
            {
                return false;
            }
        }

        public static void test1()
        {
            var dao = new IB_SalaireDao();
            var metier = new IB_SalaireMetier();
            var controleur = new IB_SalaireControleur();

            metier.setSalaireDao(dao);
            controleur.setSalaireMetier(metier);
            String rep = "";
            do{
                System.out.println("=>Calcule de salaire ");
                try {
                    String input = "";
                    while (true)
                    {
                        System.out.print("entrer l 'id : ");
                        input = clavier.nextLine();
                        if(estUnNombre(input))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("entrer non valide");
                        }
                    }
                    Long id = Long.parseLong(input);
                    controleur.afficher_SalaireNet(id);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                System.out.println("voulez vous quitter : ");
                rep = clavier.nextLine();
            }while (!rep.equalsIgnoreCase("oui"));
            System.out.println("bye");


        }

    public static void test3() throws Exception
    {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring-ioc.xml");
        salaireControleur = (IB_IControleur) context.getBean("controleur");
        salaireControleur.afficher_SalaireNet(1L);
    }

    public static void test4() throws Exception
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier","presentation");
        salaireControleur = (IB_IControleur) context.getBean(IB_IControleur.class);
        salaireControleur.afficher_SalaireNet(1L);



    }

    public static void main(String[] args) throws Exception{
           test4();

    }

    }

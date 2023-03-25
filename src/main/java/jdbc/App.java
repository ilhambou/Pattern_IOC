package jdbc;

import Modele.IB_Salaire;

import java.sql.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/salaires";
        var login = "root";
        var pass = "";
        Connection connection=null;
        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList salaires = new ArrayList<IB_Salaire>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("le driver de mysql a ete charge avec succes");
            connection = DriverManager.getConnection(url,login,pass);
            System.out.println("cnx etablit avec succe");
            statement = connection.createStatement();
            //statement.executeQuery("SELECT * FROM salaire where ");
            //ps = connection.prepareStatement("select * from salaire where id = ?");
            //ps.setLong(1,3L);
            ps = connection.prepareStatement("select * from salaire");
            rs = ps.executeQuery();
            while (rs.next())
            {
                var id = rs.getLong("IB_id");
                var salaire_brut = rs.getDouble("IB_salaire_brut");
                var total_retenues_salariales = rs.getDouble("IB_total_retenues_salariales");
                var heurescompl = rs.getDouble("IB_heurescompl");
                var CSG_non_deductible = rs.getDouble("IB_CSG_non_deductible");
                var CSG_CRDS_non_deductible = rs.getDouble("IB_CSG_CRDS_non_deductible");
                var Participation_patronale = rs.getDouble("IB_Participation_patronale");
                var Salaire_net = rs.getDouble("IB_Salaire_net");


                IB_Salaire salaire = new IB_Salaire(id,salaire_brut,total_retenues_salariales,heurescompl,CSG_non_deductible,CSG_CRDS_non_deductible,Participation_patronale,Salaire_net);
                salaires.add(salaire);




            }
            salaires.forEach(System.out::println);

        } catch (ClassNotFoundException e) {
            System.out.println("Le driver du MySQL est introuvble" );
        } catch (SQLException e) {
            System.out.println("Connexion échouée");
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Connexion fermé avec succ ");
                }
            } catch (SQLException e) {
                System.out.println("Connexion n'est pas fermé av succ");

            }
            try {
                if(ps != null)
                {
                    ps.close();
                    System.out.println("Connexion ferme av succ ");
                }
            } catch (SQLException e) {
                System.out.println("Connexion n'a pas pu etre femrme");
            }
            try {
                if(connection != null)
                {
                    connection.close();
                    System.out.println("Connexion ffermeavec succes ");
                }
            } catch (SQLException e) {
                System.out.println("Connexion n'a pas pu etre ferme");
            }


        }
    }
}
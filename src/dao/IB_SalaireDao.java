package dao;

import Modele.IB_Salaire;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component("dao")


public class IB_SalaireDao implements IB_IDao<IB_Salaire,Long>{


    public static Set<IB_Salaire> IB_BDSalaires()
    {
        return new HashSet<IB_Salaire>(
                Arrays.asList(
                        new IB_Salaire(1L,22333.866,1333.77,334.76,234.87,344.0,234.0,0.0),
                        new IB_Salaire(2L,976.866,276.77,133.76,999.87,123.0,1.0,0.0)




                        )
        );


    }




    public IB_Salaire trouverParId(Long id)
    {
        System.out.println("touver le id num : " + id);
        return IB_BDSalaires().stream().filter(salaire -> salaire.getIB_id() == id).findFirst().orElse(null);

    }




}

package presentation;

import Metier.IB_IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class IB_SalaireControleur implements IB_IControleur{
    @Autowired
    @Qualifier("metier")

   IB_IMetier salaireMetier;


    public void setSalaireMetier(IB_IMetier salaireMetie) {
        this.salaireMetier = salaireMetie;
    }


    @Override
    public void afficher_SalaireNet(Long idSalaire) throws Exception {
        var Salairenettt = salaireMetier.calcule_Salaire(idSalaire);
        System.out.println(Salairenettt);
    }
}

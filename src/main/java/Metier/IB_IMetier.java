package Metier;

import Modele.IB_Salaire;

public interface IB_IMetier {
    IB_Salaire calcule_Salaire(Long idSalaire) throws Exception;

}

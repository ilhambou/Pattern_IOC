package Metier;

import Modele.IB_Salaire;
import dao.IB_IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("metier")
public class IB_SalaireMetier implements IB_IMetier{
    @Autowired
    @Qualifier("dao")
    IB_IDao<IB_Salaire,Long> salaireDao;

    public IB_IDao<IB_Salaire, Long> setSalaireDao(IB_IDao<IB_Salaire,Long> dao){
        return  this.salaireDao = dao;
    }




    @Override
    public IB_Salaire calcule_Salaire(Long idSalaire) throws Exception {

        var salaire = salaireDao.trouverParId(idSalaire);

        if (salaire == null) {
            throw new Exception("l id est incorrecte ");

        } else {

            double IB_salairenet = salaire.getIB_salaire_brut()-salaire.getIB_total_retenues_salariales()-salaire.getIB_heurescompl()+salaire.getIB_CSG_CRDS_non_deductible()+salaire.getIB_CSG_non_deductible()+salaire.getIB_Participation_patronale();

            salaire.setIB_Salaire_net(IB_salairenet);
            return salaire;
        }

    }
}

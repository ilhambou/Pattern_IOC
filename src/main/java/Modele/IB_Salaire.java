package Modele;

public class IB_Salaire {
    private Long IB_id;
    private Double IB_salaire_brut;
    private Double IB_total_retenues_salariales;
    private Double IB_heurescompl;
    private Double IB_CSG_non_deductible;
    private Double IB_CSG_CRDS_non_deductible;
    private Double IB_Participation_patronale;
    private Double IB_Salaire_net;

    public void setIB_Salaire_net(Double IB_Salaire_net) {
        this.IB_Salaire_net = IB_Salaire_net;
    }

    public IB_Salaire(Long IB_id, Double IB_salaire_brut, Double IB_total_retenues_salariales, Double IB_heurescompl, Double IB_CSG_non_deductible, Double IB_CSG_CRDS_non_deductible, Double IB_Participation_patronale, Double IB_Salaire_net)
    {
        this.IB_id=IB_id;
        this.IB_salaire_brut = IB_salaire_brut;
        this.IB_heurescompl = IB_heurescompl;
        this.IB_CSG_non_deductible=IB_CSG_non_deductible;
        this.IB_total_retenues_salariales=IB_total_retenues_salariales;
        this.IB_CSG_CRDS_non_deductible=IB_CSG_CRDS_non_deductible;
        this.IB_Participation_patronale=IB_Participation_patronale;
        this.IB_Salaire_net = IB_Salaire_net;

    }

    public Double getIB_CSG_CRDS_non_deductible() {
        return IB_CSG_CRDS_non_deductible;
    }

    public Double getIB_CSG_non_deductible() {
        return IB_CSG_non_deductible;
    }

    public Double getIB_heurescompl() {
        return IB_heurescompl;
    }

    public Double getIB_Participation_patronale() {
        return IB_Participation_patronale;
    }

    public Double getIB_salaire_brut() {
        return IB_salaire_brut;
    }

    public Double getIB_total_retenues_salariales() {
        return IB_total_retenues_salariales;
    }

    public void setIB_CSG_CRDS_non_deductible(Double IB_CSG_CRDS_non_deductible) {
        this.IB_CSG_CRDS_non_deductible = IB_CSG_CRDS_non_deductible;
    }

    public void setIB_CSG_non_deductible(Double IB_CSG_non_deductible) {
        this.IB_CSG_non_deductible = IB_CSG_non_deductible;
    }

    public void setIB_heurescompl(Double IB_heurescompl) {
        this.IB_heurescompl = IB_heurescompl;
    }

    public void setIB_id(Long IB_id) {
        this.IB_id = IB_id;
    }

    public void setIB_Participation_patronale(Double IB_Participation_patronale) {
        this.IB_Participation_patronale = IB_Participation_patronale;
    }

    public void setIB_salaire_brut(Double IB_salaire_brut) {
        this.IB_salaire_brut = IB_salaire_brut;
    }

    public void setIB_total_retenues_salariales(Double IB_total_retenues_salariales) {
        this.IB_total_retenues_salariales = IB_total_retenues_salariales;
    }

    public Long getIB_id() {
        return IB_id;
    }

    public Double getIB_Salaire_net() {
        return IB_Salaire_net;
    }

    @Override
    public String toString() {
        String IB_SalaireStr= "---------------------------------------------";
        IB_SalaireStr += "Salaire num : "+ getIB_id() + "\n";
        IB_SalaireStr += "Salaire net : "+ getIB_Salaire_net() + "\n";


        return IB_SalaireStr;
    }
}

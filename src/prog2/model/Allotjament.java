package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String id;
    private long estadaAlta;
    private long estadaBaixa;

    public Allotjament(String nom, String id, long estadaAlta, long estadaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaAlta = estadaAlta;
        this.estadaBaixa = estadaBaixa;
    }

    @Override public String getNom() { return nom; }

    @Override public void setNom(String nom) { this.nom = nom; }

    @Override public String getId() { return id; }

    @Override public void setId(String id) { this.id = id; }

    @Override
    public long getEstadaMinima(Temp temp) {
        return (temp == Temp.ALTA) ? estadaAlta : estadaBaixa;}

    @Override
    public void setEstadaMinima(long alta, long baixa) {
        this.estadaAlta = alta;
        this.estadaBaixa = baixa;
    }

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaAlta + ", estada mínima en temp BAIXA: " + estadaBaixa + ".";
    }

}


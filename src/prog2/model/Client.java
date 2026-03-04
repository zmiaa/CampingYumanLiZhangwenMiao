package prog2.model;

public class Client implements InClient {
    // atributs
    private String nom;
    private String dni;

    // constructor
    public Client(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    // s'ha d'implementar el mètode toString
    @Override
    public String toString() {
        return nom + " amb DNI: " + dni + ". ";
    }
}

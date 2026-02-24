package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {
    // atributs
    public String nom;
    public ArrayList<Allotjament> allotjaments;    // allotjaments disponibles
    private ArrayList<Client> clients; // clients del càmping
    private LlistaReserves reserves; // llista de reserves

    // constructor
    public Camping(String nom) {
        this.nom = nom;
    }

    // mètodes
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return reserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return allotjaments;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return clients;
    }

    @Override
    public int getNumAllotjaments() {
        return allotjaments.size();
    }

    @Override
    public int getNumReserves() {
        return 0;
    }

    @Override
    public int getNumClients() {
        return clients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) {

    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {

    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {

    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {

    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {

    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {

    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

    }

    @Override
    public int calculAllotjamentsOperatius() {
        return 0;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        return null;
    }

    // mètodes
    public Allotjament buscarAllotjament(String DNI) {
        return null;
    }

    public Client buscarClient(String DNI){
        // aquest mètode utilitzarà el mètode afegirReserva de Camping
        return null;
    }

    /*
    Que retornarà la temporada corresponent a la data passada com a paràmetre. S’ha
    d’analitzar si la data està en el període del 21 de març al 20 de setembre (temporada
    alta) o en el període del 21 de setembre al 20 de març (temporada baixa). Per fer-ho
    s’han de fer servir els mètodes getDayOfMonth i getMonthValue de la classe LocalDate
    que Obté el camp del dia del mes de l’1 al 31 i del mes de l'any de l'1 al 12,
    respectivament.
     */
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        return null;
    }
}

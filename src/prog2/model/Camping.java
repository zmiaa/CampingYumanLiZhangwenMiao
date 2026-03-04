package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping {
    // atributs
    public String nom;
    public ArrayList<Allotjament> allotjaments;    // allotjaments disponibles
    private ArrayList<Client> clients; // clients del càmping
    private LlistaReserves reserves; // llista de reserves

    // constructor
    public Camping(String nom) {

        this.nom = nom;
        this.allotjaments = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new LlistaReserves();
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
        return reserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return clients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client nouClient = new Client(nom_, dni_);
        clients.add(nouClient);

    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        allotjaments.add(new Parcela(nom_, idAllotjament_, metres, connexioElectrica));

    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        allotjaments.add(new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred));

    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        allotjaments.add(new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi));
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        allotjaments.add(new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota));
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        allotjaments.add(new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa));
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);
        if (allotjament == null) {
            throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");
        }
        if (client == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
        }
        reserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);

    }

    @Override
    public int calculAllotjamentsOperatius() {
        int count = 0;
        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) {
            if (it.next().correcteFuncionament()){
                count++;
            }
        }
        return count;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        if (allotjaments.isEmpty()) return null;

        Allotjament mesCurt = null;
        Iterator<Allotjament> it = allotjaments.iterator();

        while (it.hasNext()) {
            Allotjament actual = it.next();
            if (mesCurt == null || actual.getEstadaMinima(temp) < mesCurt.getEstadaMinima(temp)) {
                mesCurt = actual;
            }
        }
        return mesCurt;
    }

    // mètodes
    public Allotjament buscarAllotjament(String id) {
        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) {
            Allotjament a = it.next();
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }


    public Client buscarClient(String dni){
        // aquest mètode utilitzarà el mètode afegirReserva de Camping
            Iterator<Client> it = clients.iterator();
            while (it.hasNext()) {
                Client c = it.next();
                if (c.getDni().equals(dni)) {
                    return c;
                }
            }
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
        int mes = data.getMonthValue(); //Obté el mes de l'any de l'1 al 12
        int dia = data.getDayOfMonth(); //Obté el día del mes de l’1 al 31

        //Temporada alta: del 21 de març al 20 de setembre
        if((mes > 3 && mes <9 ) || (mes == 3 && dia >= 21) || (mes == 9 && dia <= 20)){
            return InAllotjament.Temp.ALTA;
        }
        //Temporada baixa: del 21 de setembre al 20 de març
        else{
            return InAllotjament.Temp.BAIXA;
        }
    }
}

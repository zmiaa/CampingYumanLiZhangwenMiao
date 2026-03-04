package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class BungalowPremium extends Allotjament {
    private String mida;
    private int habitacions, placesPersones, placesParquing;
    private boolean terrassa, tv, aireFred, serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String id, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom, id, 7, 4);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    /* Un Bungalow Premium funciona correctament si té aire fred i
       el codi Wifi té entre 8 i 16 caràcters.*/
    @Override
    public boolean correcteFuncionament() {
        boolean wifiValid = codiWifi != null && codiWifi.length() >= 8 && codiWifi.length() <= 16;
        return aireFred && wifiValid;
    }

    public boolean isServeisExtra(){
        return serveisExtra;
    }

    public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra = serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

        @Override
    public String toString() {
        return super.toString() + " BungalowPremium {mida=" + mida + ", habitacions=" + habitacions +
                ", placesPersones=" + placesPersones + ", placesParquing=" + placesParquing +
                ", terrassa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred +
                ", serveisExtra=" + serveisExtra + ", codiWifi='" + codiWifi + "'}";
        }
}

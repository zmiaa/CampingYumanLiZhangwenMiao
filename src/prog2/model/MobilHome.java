package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class MobilHome extends Allotjament {
   private String mida;
   private int habitacions;
   private int placesPersones;
   private boolean terrassaBarbacoa;

    public MobilHome(String nom, String id, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, id, 5, 3);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    /* Una Mobil-Home funciona correctament si té terrassa amb barbacoa.*/
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    public String getMida() { return mida; }
    public void setMida(String mida) { this.mida = mida; }
    public int getHabitacions() { return habitacions; }
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }
    public int getPlacesPersones() { return placesPersones; }
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }

    @Override
    public String toString() {
        return super.toString() + " MobilHome {mida=" + mida + ", habitacions=" + habitacions +
                ", placesPersones=" + placesPersones + ", terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }


}

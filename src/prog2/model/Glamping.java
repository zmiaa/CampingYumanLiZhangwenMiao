package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Glamping extends Allotjament {
    private String mida;
    private int habitacions;
    private int placesPersones;
    private String materials;
    private boolean casaMascota;

    public Glamping(String nom, String id, String mida, int habitacions, int placesPersones, String materials, boolean casaMascota) {
        super(nom, id, 3, 3);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.materials = materials;
        this.casaMascota = casaMascota;
    }

    /* Un Glamping funciona correctament si té una casa per a mascota. */
    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    public String getMida() {
        return mida;
    }

    public void setMIda(String mida) {
        this.mida = mida;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public int getPlacesPersones() {
        return placesPersones;
    }

    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public boolean isCasaMascota() {
        return casaMascota;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

     @Override
    public String toString() {
         return super.toString() + " Glamping {mida=" + mida + ", material=" + materials + ", casaMascota=" + casaMascota + "}";
     }
}

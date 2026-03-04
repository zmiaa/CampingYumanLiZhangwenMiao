package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> llista;

    public LlistaReserves() {
        this.llista = new ArrayList<>();
    }

    /**
     * Comprova si l'allotjament està lliure en les dates demanades.
     */
    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        Iterator<Reserva> it = llista.iterator();
        while (it.hasNext()) {
            Reserva reserva = it.next();
            // Comprovem si la reserva existent és per al mateix allotjament
            if (reserva.getAllotjament_().getId().equals(allotjament.getId())) {
                // Hi ha solapament si les dates s'encavalquen
                // No hi ha solapament si: novaSortida <= reservaEntrada O novaEntrada >= reservaSortida
                if (!(dataSortida.isBefore(reserva.getDataEntrada()) || dataSortida.isEqual(reserva.getDataEntrada()) ||
                        dataEntrada.isAfter(reserva.getDataSortida()) || dataEntrada.isEqual(reserva.getDataSortida()))) {
                    return false; // Hi ha solapament
                }
            }
        }
        return true;
    }

    /**
     * Comprova si l'estada compleix l'estada mínima de l'allotjament segons la temporada.
     */
    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        // Calculem la durada en dies
        long diesEstada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        // Obtenim la temporada de la data d'entrada
        InAllotjament.Temp temp = Camping.getTemporada(dataEntrada);
        // Comparem amb l'estada mínima de l'allotjament
        return diesEstada >= allotjament.getEstadaMinima(temp);
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // 1. Comprovar disponibilitat
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() +
                    " no està disponible en la data demanada " + dataEntrada + " pel client " +
                    client.getNom() + " amb DNI: " + client.getDni() + "."); //
        }

        // 2. Comprovar estada mínima
        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() +
                    " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " +
                    allotjament.getId() + "."); //
        }

        // 3. Si tot és correcte, crear la reserva i afegir-la a la llista
        llista.add(new Reserva(allotjament, client, dataEntrada, dataSortida));
    }

    @Override
    public int getNumReserves() {
        return llista.size(); //
    }
}
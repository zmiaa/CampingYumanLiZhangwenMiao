package prog2.model;

import java.time.LocalDate;
import prog2.vista.ExcepcioReserva;

public class Reserva implements InReserva {
    // atributs
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        if (dataSortida.isBefore(dataEntrada)) {
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }

        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    @Override
    public Allotjament getAllotjament_() {
        return allotjament;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    @Override
    public LocalDate getDataSortida() {
        return dataSortida;
    }


    @Override
    public void setAllotjament_(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    @Override
    public void setClient(Client client_) {
        this.client = client_;
    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada_) {
        this.dataEntrada = dataEntrada_;
    }

    @Override
    public void setDataSortida(LocalDate dataSortida_) {
        this.dataSortida = dataSortida_;
    }


}

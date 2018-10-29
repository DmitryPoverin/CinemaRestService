package cinema.service.model;

import cinema.service.exeptions.SeatAlreadyReservedException;

import javax.xml.bind.annotation.XmlTransient;
import java.beans.Transient;

enum SeatStatus{
    RESERVED("Reserved"), // Место забронировано
    FREE("Free"), // Место свободно
    SALES("Sales"); // Место занято (билет продан)

    private String status;

    SeatStatus(String status){
        this.status = status;
    }
}

public class Seat extends Entity<Long> implements Cloneable{
    public Seat(Long id) {
        super(id);
        this.status = SeatStatus.FREE;
    }

    private SeatStatus status;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Seat copySeat = new Seat(new Long(id));
        copySeat.status = this.status;
        return copySeat;
    }

    @XmlTransient
    public boolean isReserved(){
        return status.equals(SeatStatus.RESERVED);
    }
    @XmlTransient
    public boolean isSales(){
        return status.equals(SeatStatus.SALES);
    }
    @XmlTransient
    public boolean isFree(){
        return status.equals(SeatStatus.FREE);
    }

    public String getStatus(){
        return status.toString();
    }

    public void reserve() throws SeatAlreadyReservedException {
        this.status = SeatStatus.RESERVED;
            }

    public void sell(){
        this.status = SeatStatus.SALES;
    }

    public void free(){
        this.status = SeatStatus.FREE;
    }
}
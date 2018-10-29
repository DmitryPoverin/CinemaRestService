package cinema.service.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Hall extends Entity<Long> implements Cloneable {
    public Hall(Long id, ConcurrentMap<Long, Seat> seats) {
        super(id);
        this.seats = seats;
    }

    private ConcurrentMap<Long, Seat> seats = new ConcurrentHashMap<>();
    public Seat getSeat(Long idSeat){
        return this.seats.get(idSeat);
    }
    public Iterable getSeats(){
        return seats.values();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ConcurrentMap<Long, Seat> copySeats = new ConcurrentHashMap<>();
        Collection<Seat> entries = seats.values();

        for(Seat item: entries){
            Seat copyItem = (Seat) item.clone();
            copySeats.put(copyItem.getId(), copyItem);
        }
        Hall copyHall = new Hall(new Long(id), copySeats);
        return copyHall;
    }
}

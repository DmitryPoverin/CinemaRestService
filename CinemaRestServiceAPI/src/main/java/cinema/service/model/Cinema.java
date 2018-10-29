package cinema.service.model;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@XmlRootElement
public class Cinema extends Entity<Long>{
    public Cinema(Long id, String name) {
        super(id);
        this.name = name;

        halls = new ConcurrentHashMap<>();
        sessions = new ConcurrentHashMap<>();
    }

    private String name;

    public String getName() {
        return name;
    }

    public SessionCinema getSession(Long id){
        return sessions.get(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addHall(Hall hall){
        halls.put(hall.getId(), hall);
    }

    public void deleteSession(Long idSession){
        sessions.remove(idSession);
    }

    public void deleteHall(Long idHall){
        halls.remove(idHall);
    }

    public void createNewSession(long idSession, Date timeBegin, Date timeEnd, FilmInfo filmInfo, Long idHall ) throws CloneNotSupportedException {
        Hall copyHall = (Hall) halls.get(idHall).clone();
        SessionCinema sessionCinema = new SessionCinema(idSession, timeBegin, timeEnd, filmInfo, copyHall);
        sessions.put(idSession, sessionCinema);
    }

    @XmlTransient
    public Iterable getAllSessions(){
        return new LinkedList(sessions.values());
    }
    @XmlTransient
    private ConcurrentMap<Long, Hall> halls;
    @XmlTransient
    private ConcurrentMap<Long, SessionCinema> sessions;
}

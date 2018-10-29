package cinema.service.model;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

public class SessionCinema extends Entity<Long> {

    private Date timeBegin;
    private Date timeEnd;
    private FilmInfo film;
    private Hall hall;

    public SessionCinema(Long id, Date timeBegin, Date timeEnd, FilmInfo film, Hall hall) {
        super(id);
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.film = film;
        this.hall = hall;
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public FilmInfo getFilm() {
        return film;
    }

    @XmlTransient
    public Hall getHall() {
        return hall;
    }

    public Long getIdHall(){
        return hall.getId();
    }
}

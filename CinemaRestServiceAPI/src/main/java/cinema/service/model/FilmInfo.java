package cinema.service.model;

public class FilmInfo extends Entity<Long> {
    public FilmInfo(Long id, String name, String director, byte durationInMinutes) {
        super(id);
        this.name = name;
        this.director = director;
        this.durationInMinutes = durationInMinutes;
    }

    private String name; // Название фильма
    private String director; // Режиссёр
    private byte durationInMinutes; // Продолжительность в минутах

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public byte getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(byte durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

}

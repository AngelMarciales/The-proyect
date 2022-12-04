package Models;

public class Function implements Comparable<Function>{

    private int id;
    private String format;
    private Film film;
    private String hour;
    private int cost;
    private Room room;

    public Function(int id, String format, Film film, String hour, int[] cost2, Room room) {
        this.id = id;
        this.format = format;
        this.film = film;
        this.hour = hour;
        this.cost = cost2;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getFormat() {
        return format;
    }

    public Film getFilm() {
        return film;
    }

    public String getHour() {
        return hour;
    }

    public int getCost() {
        return cost;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public int compareTo(Function o) {
        return id - o.getId();
    }
}

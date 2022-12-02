package Models;

public class Function implements Comparable<Function>{

    private int id;
    private String format;
    private Film film;
    private String hour;
    private int cost;
    private Room room;

    public Function(int id, String format, Film film, String hour, int cost, Room room) {
        this.id = id;
        this.format = format;
        this.film = film;
        this.hour = hour;
        this.cost = cost;
        this.room = room;
    }

    public int getId() {
        return id;
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

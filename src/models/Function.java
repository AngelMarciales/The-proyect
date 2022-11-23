package models;

public class Function {
    
    private int id;
    private String format;
    private Film film;
    private String hourAndRoom;
    private int cost;
    private boolean chairsLeft[][];
    private boolean chairsCenter[][];
    private boolean chairsRigth[][];

    public Function(int id, String format, Film film, String hourAndRoom, int cost){
        this.id = id;
        this.format = format;
        this.film = film;
        this.hourAndRoom = hourAndRoom;
        this.cost = cost;
        chairsLeft = new boolean[6][2];
        chairsCenter = new boolean[6][3];
        chairsRigth = new boolean[6][2];
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

    public String getHourAndRoom() {
        return hourAndRoom;
    }

    public boolean[][] getChairsLeft() {
        return chairsLeft;
    }

    public boolean[][] getChairsCenter() {
        return chairsCenter;
    }

    public boolean[][] getChairsRigth() {
        return chairsRigth;
    }

    public int getCost() {
        return cost;
    }
}

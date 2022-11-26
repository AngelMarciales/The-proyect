package Models;

public class Room {

    private int id;
    private Chair[][] chairList;

    public Room(int id) {
        this.id = id;
        chairList = new Chair[10][10];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chair[][] getChairList() {
        return chairList;
    }

    public void setChairList(Chair[][] chairList) {
        this.chairList = chairList;
    }

}

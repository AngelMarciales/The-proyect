package Controller;

public class Room {

    private int id;
    private Chair[][] chairList;

    public Room(int id) {
        this.id = id;
        chairList = new Chair[6][7];
        int count = 1;
        for (int i = 0; i < chairList.length; i++) {
            for (int j = 0; j < chairList[i].length; j++) {
                chairList[i][j] = new Chair(count);
                count++;
            }
        }
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

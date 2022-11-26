package Models;

public class Chair {

    private int id;
    private boolean state;

    public Chair(int id) {
        this.id = id;
        state = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}

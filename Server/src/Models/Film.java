package Models;

public class Film {
    
    private String name;
    private String director;
    private int popularity;

    public Film (String name, String director, String image){
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularityMax(int num) {
        popularity += num;
    }

    public void setPopularityMin(int num) {
        popularity -= num;
    }
}

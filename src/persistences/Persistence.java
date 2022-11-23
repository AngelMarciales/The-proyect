package persistences;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import models.Film;
import models.Function;

public class Persistence {
    
    private ArrayList<Function> funcTionList;
    private ArrayList<Film> filmList;

    public Persistence(){
        funcTionList = new ArrayList<Function>();
        filmList = new ArrayList<Film>();
    }

    public void readFunction() throws FileNotFoundException{
        JsonReader reader = new Gson().newJsonReader(new FileReader("data/functionList.json"));
        Function[] functions = new Gson().fromJson(reader, Function[].class);
        for (int i = 0; i < functions.length; i++) {
            funcTionList.add(functions[i]);
        }

    }

    public void readFilm() throws FileNotFoundException{
        JsonReader reader = new Gson().newJsonReader(new FileReader("data/filmList.json"));
        Film[] films = new Gson().fromJson(reader, Film[].class);
        for (int i = 0; i < films.length; i++) {
            filmList.add(films[i]);
        }

    }

    public void writeFunction(ArrayList<Function> functions) throws FileNotFoundException{
        String json = new Gson().toJson(functions);

        PrintWriter print = new PrintWriter("data/functionList.json");
        print.write(json);
        print.close();
    }

    public void writeFilm(ArrayList<Film> films) throws FileNotFoundException{
        String json = new Gson().toJson(films);

        PrintWriter print = new PrintWriter("data/filmList.json");
        print.write(json);
        print.close();
    }

    public ArrayList<Function> getFuncTionList() {
        return funcTionList;
    }

    public ArrayList<Film> getFilmList() {
        return filmList;
    }
}

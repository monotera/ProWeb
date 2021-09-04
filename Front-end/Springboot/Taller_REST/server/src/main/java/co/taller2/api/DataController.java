package co.taller2.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class DataController {

    public void writeData(ArrayList<Trip> trips) {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = prettyGson.toJson(trips);

        try {
            FileWriter fr = new FileWriter("resources/data.json");
            fr.write(prettyJson);
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<Trip> getData() {

        Type tripListType = new TypeToken<ArrayList<Trip>>() {
        }.getType();
        JsonReader datatrip;
        Gson g = new Gson();
        try {
            datatrip = new JsonReader(new FileReader("resources/data.json"));
            ArrayList<Trip> trips = g.fromJson(datatrip, tripListType);
            return trips;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

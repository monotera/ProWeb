package co.taller2.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip {
    int id;
    String name;
    String place_departure;
    String place_arrival;
    String date;

    @Override
    public String toString() {
        return "Paseo [fecha=" + date + ", id=" + id + ", Place_arrival=" + place_arrival + ", place_departure="
                + place_departure + ", name=" + name + "]";
    }

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_departure() {
        return place_departure;
    }

    public void setPlace_departure(String place_departure) {
        this.place_departure = place_departure;
    }

    public String getPlace_arrival() {
        return place_arrival;
    }

    public void setPlace_arrival(String Place_arrival) {
        this.place_arrival = Place_arrival;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String fecha) {
        this.date = fecha;
    }

    public Trip(int id, String name, String place_departure, String place_arrival, String date) {
        this.id = id;
        this.name = name;
        this.place_departure = place_departure;
        this.place_arrival = place_arrival;
        this.date = date;
    }

}

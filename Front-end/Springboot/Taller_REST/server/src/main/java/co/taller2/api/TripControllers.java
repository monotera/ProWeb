package co.taller2.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("home")
public class TripControllers {
    DataController dc = new DataController();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("trips")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<Trip> printtrips() {
        ArrayList<Trip> trips = dc.getData();
        return trips;
    }

    @GET
    @Path("trip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findtripById(@QueryParam("id") int id) {
        ArrayList<Trip> trips = dc.getData();
        for (Trip trip : trips) {
            if (trip.getId() == id)
                return Response.status(200).entity(trip).build();
        }
        return Response.status(404).build();
    }

    @POST
    @Path("create_trip")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrip(Trip trip) {
        ArrayList<Trip> trips = dc.getData();
        trip.setId(trips.size());
        trips.add(trip);
        dc.writeData(trips);
        return Response.status(201).entity(trip).build();
    }

    @DELETE
    @Path("delete_trip")
    public Response deleteTrip(@QueryParam("id") int id) {
        ArrayList<Trip> trips = dc.getData();
        for (Trip trip : trips) {
            if (trip.getId() == id) {
                trips.remove(trip);
                dc.writeData(trips);
                return Response.status(200).entity(trip).build();
            }
        }
        return Response.status(404).build();
    }

    @PUT
    @Path("update_trip")
    public Response updateTrip(@QueryParam("id") int id, @QueryParam("name") String name) {
        ArrayList<Trip> trips = dc.getData();
        for (Trip trip : trips) {
            if (trip.getId() == id) {
                trip.setName(name);
                dc.writeData(trips);
                return Response.status(200).entity(trip).build();
            }
        }
        return Response.status(404).build();
    }

}

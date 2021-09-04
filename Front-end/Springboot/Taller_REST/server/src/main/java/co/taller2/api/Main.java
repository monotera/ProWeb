package co.taller2.api;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class. mvn clean install mvn exec::java
 */
public class Main {

    public static final String BASE_URI = "http://localhost:3000/";

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in co.taller2.api package
        final ResourceConfig rc = new ResourceConfig().packages("co.taller2.api");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format(
                "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI));
        System.in.read();
        server.shutdown();
    }
}

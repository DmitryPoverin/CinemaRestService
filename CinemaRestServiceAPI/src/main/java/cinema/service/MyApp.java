package cinema.service;

import cinema.service.helpers.Helper;
import cinema.service.utils.CinemasStorageServiceBinder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class MyApp extends ResourceConfig {

    public MyApp(){

    }

    public static void main(String[] args) throws Exception {
        runApp();
    }

    static void runApp() throws Exception{
        Helper helper = new Helper();
        helper.initFilms();
        helper.initCinemas();

        ResourceConfig config = new ResourceConfig();
        CinemasStorageServiceBinder binder = new CinemasStorageServiceBinder();
        config.register(binder);
        config.register(JacksonFeature.class);
        config.packages(true, "cinema.service");

        ServletHolder jerseyServlet
                = new ServletHolder(new ServletContainer(config));

        Server server = new Server(8080);
        ServletContextHandler context
                = new ServletContextHandler(server, "/");
        context.addServlet(jerseyServlet, "/*");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
package cart.server.rest;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import cart.server.common.Params;

public class RestStartup {
 
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServerFactory.create(Params.API_REST_URI);
            server.start();
            System.out.println("Press Enter to stop the server. ");
            System.in.read();
            server.stop(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

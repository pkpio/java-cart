package cart.server.rest;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import cart.server.common.Params;

public class RestStartup {

	public static void startService() {
		try {
			HttpServer server = HttpServerFactory.create(Params.API_REST_URI);
			server.start();
			System.out.println("REST Server Started!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

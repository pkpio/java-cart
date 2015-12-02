package cart.server.soap;

import javax.xml.ws.Endpoint;

import cart.server.common.Params;

public class SoapStartup {

	public static void startService() {
		Endpoint.publish(Params.API_SOAP_URI, new SoapService());
		System.out.println("SOAP Server Started!");
	}
}

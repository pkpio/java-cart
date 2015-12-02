package cart.server.soap;

import javax.xml.ws.Endpoint;

import cart.server.common.Params;
import cart.server.common.WebServiceCommon;

public class SoapStartup {

	public static void main(String[] args) {
		// Init products first
		WebServiceCommon.initProductData();

		Endpoint.publish(Params.API_SOAP_URI, new SoapService());
		System.out.println("SOAP Server Started!");
	}
}

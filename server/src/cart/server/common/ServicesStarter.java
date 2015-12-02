package cart.server.common;

import cart.server.rest.RestStartup;
import cart.server.soap.SoapStartup;

public class ServicesStarter {

	public static void main(String[] args) {
		// Init products first
		WebServiceCommon.initProductData();

		RestStartup.startService();
		SoapStartup.startService();
	}

}

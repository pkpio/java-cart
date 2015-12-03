package cart.client.ui;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cart.client.control.ClientCtrl;

/**
 * This is the entry point for client application.
 * 
 * @author Ram
 */
public class ClientApp {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		// Decide the type of client back end we are going to use
		int apiType;
		String type;
		if (args.length > 0 && args[0].contentEquals("rest")) {
			apiType = ClientCtrl.API_TYPE_REST;
			type="-REST";
			System.out.println("Client using REST for backend");
		} else {
			apiType = ClientCtrl.API_TYPE_SOAP;
			type="-SOAP";
			System.out.println("Client using SOAP for backend");
		}

		try {
			new ClientView(new ClientCtrl(apiType),type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

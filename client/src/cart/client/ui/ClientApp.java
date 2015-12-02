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

		try {
			// -TODO- Ram, The client backend API type should be choosed based
			// on the arguments passed while starting the client. The exercise
			// asks to start a REST and SOAP client so, we have to implement the
			// arguments to main function such that one option starts client
			// with REST as API and other as SOAP
			new ClientView(new ClientCtrl(ClientCtrl.API_TYPE_REST));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

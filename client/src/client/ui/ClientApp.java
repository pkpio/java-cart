package client.ui;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.control.ClientCtrl;
import client.ui.ClientView;


/**
 * This is the entry point for client application.
 * 
 * @author Ram
 */
public class ClientApp {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		try {
			new ClientView(new ClientCtrl(ClientCtrl.API_TYPE_REST));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

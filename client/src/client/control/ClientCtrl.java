package client.control;

import java.util.HashMap;
import java.util.Map;

public class ClientCtrl {
	Map<String, Integer> cart;

	/*
	 * on checkout perform the REST call for purchase
	 */
	public ClientCtrl(){
		this.cart= new HashMap<String, Integer>();
	}
	public void performCheckout() {
		System.out.println("Checking out");
	}

	public void addToCart(String productId, Integer quantity) {
		System.out.println("Product added");
		this.cart.put(productId, quantity);
		
	}

}

package client.control;

public class ClientCtrl {
	public static final int API_TYPE_REST = 1;
	public static final int API_TYPE_SOAP = 2;

	int mApiType = API_TYPE_REST;

	/**
	 * State info for future calls
	 */
	String mUserid;

	/**
	 * Initialize the client with the type of API endpoint to be used for
	 * backend calls
	 * 
	 * @param apiType
	 */
	public ClientCtrl(int apiType) {
		this.mApiType = apiType;
	}

	/**
	 * Login with given userid
	 * 
	 * @param userid
	 */
	public void login(String userid) {
		this.mUserid = userid;
	}

	/**
	 * Logout the client
	 */
	public void logout() {

	}

	/**
	 * List all available products in the store
	 */
	public void listProducts() {

	}

	/**
	 * Add the product to cart
	 * 
	 * @param productid
	 */
	public void addToCart(int productid) {

	}

	/**
	 * Remove the product from cart
	 * 
	 * @param productid
	 */
	public void removeFromCart(int productid) {

	}

	public void performCheckout() {

	}

}

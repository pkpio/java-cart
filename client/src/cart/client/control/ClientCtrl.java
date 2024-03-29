package cart.client.control;

import com.google.gson.Gson;

import cart.client.ui.ClientView;
import cart.common.model.CartAPIResponse;
import cart.common.model.Product;

/**
 * Abstracts the client - server communication. Offers REST and SOAP as options
 * for backend API at the time of controller initialization.
 * 
 * @author praveen
 *
 */
public class ClientCtrl {
	public static final int API_TYPE_REST = 1;
	public static final int API_TYPE_SOAP = 2;

	/**
	 * State info for future calls
	 */
	int mApiType;
	APICommonCtrl mApiInterface;
	String mUserid;
	ClientView clientView;

	/**
	 * Initialize the client with the type of API endpoint to be used for
	 * backend calls
	 * 
	 * @param apiType
	 */
	public ClientCtrl(int apiType) {
		mApiType = apiType;
		if (apiType == API_TYPE_REST)
			mApiInterface = new RestCtrl();
		else
			mApiInterface = new SoapCtrl();
	}

	/**
	 * Login with given userid
	 * 
	 * @param userid
	 * @return True if login success
	 */
	public Boolean login(String userid) {
		mUserid = userid;
		String response = mApiInterface.login(userid);
		CartAPIResponse resp = new Gson().fromJson(response, CartAPIResponse.class);
		return resp.getStatus() == 200;
	}

	/**
	 * Logout the client
	 * 
	 * @return True if logout success
	 */
	public Boolean logout() {
		String response = mApiInterface.logout(mUserid);
		CartAPIResponse resp = new Gson().fromJson(response, CartAPIResponse.class);
		return resp.getStatus() == 200;
	}

	/**
	 * List all available products in the store
	 * 
	 * @return list of all products in the store as an array of products
	 */
	public Product[] listProducts() {
		String response = mApiInterface.listProducts();
		return new Gson().fromJson(response, Product[].class);
	}

	/**
	 * Add the product to cart
	 * 
	 * @param productid
	 * @return list of all products in the cart
	 */
	public Product[] addToCart(int productid) {
		String response = mApiInterface.addToCart(mUserid, productid);
		return new Gson().fromJson(response, Product[].class);
	}

	/**
	 * Remove the product from cart
	 * 
	 * @param productid
	 * @return list of all products in the cart
	 */
	public Product[] removeFromCart(int productid) {
		String response = mApiInterface.removeFromCart(mUserid, productid);
		return new Gson().fromJson(response, Product[].class);
	}

	/**
	 * List all the product in the cart
	 * 
	 * @return list of all products in the cart
	 */
	public Product[] listCart() {
		String response = mApiInterface.listCart(mUserid);
		return new Gson().fromJson(response, Product[].class);
	}

	/**
	 * Checkout the products in the cart
	 * 
	 * @return True if checkout success
	 */
	public CartAPIResponse checkout() {
		String response = mApiInterface.checkout(mUserid);
		return new Gson().fromJson(response, CartAPIResponse.class);
	}

	/**
	 * Get the API backend being used for the client
	 * 
	 * @return Api Type
	 */
	public int getApiType() {
		return mApiType;
	}

	/**
	 * object used for call backs
	 * 
	 * @param view
	 */
	public void setClientView(ClientView view) {
		clientView = view;

	}

	public ClientView getClientView() {
		return clientView;

	}
}

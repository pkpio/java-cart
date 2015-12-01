package cart.server.common;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

/**
 * Common webservice that evaluates functions for both REST and SOAP services
 * 
 * @author praveen
 *
 */
public class WebServiceCommon {
	static HashMap<String, Cart> mUserCarts = new HashMap<String, Cart>();
	static HashMap<Integer, Product> mProducts = new HashMap<Integer, Product>();

	public static void initProductData() {
		mProducts.put(1, new Product(1, "Pen drive", 20, 5));
		mProducts.put(2, new Product(2, "Hard disk", 200, 1));
		mProducts.put(3, new Product(3, "Desktop PC", 1000, 1));
		mProducts.put(4, new Product(4, "Mac Book", 1550, 1));
	}

	public static String login() {
		String userid = Utils.randomString(Params.USERID_LEN);
		mUserCarts.put(userid, new Cart());
		return userid;
	}

	public static String logout(String userid) {
		mUserCarts.remove(userid);
		return "Done!";
	}

	public static String listProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		for (int id : mProducts.keySet())
			products.add(mProducts.get(id));
		return new Gson().toJson(products);
	}

	public static String addToCart(int productid, String userid) {
		mUserCarts.get(userid).addProduct(mProducts.get(productid));
		return listCart(userid);
	}

	public static String listCart(String userid) {
		return new Gson().toJson(mUserCarts.get(userid));
	}

	public static String checkout(String userid) {
		// Remove the above number products for each user
		Cart userCart = mUserCarts.get(userid);

		for (Product cartProduct : userCart.getProducts().values()) {
			Product origProduct = mProducts.get(cartProduct.getId());

			// Quantity checks
			if (origProduct.quantity <= 0)
				return "Insufficient stock for product " + cartProduct.getId();

			// Remove the product from cart and decrease inventory quantity
			origProduct.quantity--;
			userCart.removeProduct(cartProduct.getId());
		}
		return "All checked out good!";
	}

}

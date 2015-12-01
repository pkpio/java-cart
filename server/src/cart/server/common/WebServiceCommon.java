package cart.server.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import cart.common.model.CartAPIResponse;
import cart.common.model.Product;

/**
 * Common webservice that evaluates functions for both REST and SOAP services
 * 
 * @author praveen
 *
 */
public class WebServiceCommon {
	// A set of all available products
	static HashMap<Integer, Product> mInventory = new HashMap<Integer, Product>();

	// Data set that stores cart information for each user
	static HashMap<String, Cart> mCarts = new HashMap<String, Cart>();

	/**
	 * Initializes some product info for the shopping service
	 */
	public static void initProductData() {
		mInventory.put(1, new Product(1, "Pen drive", 20, 5));
		mInventory.put(2, new Product(2, "Hard disk", 200, 1));
		mInventory.put(3, new Product(3, "Desktop PC", 1000, 1));
		mInventory.put(4, new Product(4, "Mac Book Pro", 1550, 1));
	}

	/**
	 * Logs in a user with given id. Initializes a fresh empty cart for new
	 * users.
	 * 
	 * @param userid
	 * @return
	 */
	public static CartAPIResponse login(String userid) {
		if (!mCarts.containsKey(userid))
			mCarts.put(userid, new Cart());
		return new CartAPIResponse(200, "success!");
	}

	/**
	 * Logs out user with given id. The cart info of the user will be discarded
	 * after this
	 * 
	 * @param userid
	 * @return
	 */
	public static CartAPIResponse logout(String userid) {
		mCarts.remove(userid);
		return new CartAPIResponse(200, "success!");
	}

	/**
	 * List of available products for purchase. List is taken from the product
	 * inventory initialized at the service start.
	 * 
	 * @return List of products
	 */
	public static ArrayList<Product> listProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		for (int id : mInventory.keySet())
			products.add(mInventory.get(id));
		return products;
	}

	/**
	 * Adds the product with given id to user's cart. If it is already in the
	 * cart, nothing changes - no support for more than one quantity of a
	 * product for the same user
	 * 
	 * @param productid
	 * @param userid
	 * @return List of products in the cart
	 */
	public static ArrayList<Product> addToCart(int productid, String userid) {
		mCarts.get(userid).addProduct(mInventory.get(productid));
		return listCart(userid);
	}

	/**
	 * Removes the product with given id from user's cart. If it is not already
	 * in the cart, nothing changes - no support for more than one quantity of a
	 * product for the same user
	 * 
	 * @param productid
	 * @param userid
	 * @return List of products in the cart
	 */
	public static ArrayList<Product> removeFromCart(int productid, String userid) {
		mCarts.get(userid).removeProduct(productid);
		return listCart(userid);
	}

	/**
	 * Lists the current products in the cart
	 * 
	 * @param userid
	 * @return List of products in the cart
	 */
	public static ArrayList<Product> listCart(String userid) {
		Cart cart = mCarts.get(userid);
		ArrayList<Product> products = new ArrayList<Product>();

		if (cart == null)
			return products;

		for (int id : cart.getProducts().keySet())
			products.add(mInventory.get(id));
		return products;
	}

	/**
	 * Finishes a hypothetical checkout for the user. If successful, after this
	 * operation, users cart would be empty and the quantity of checked out
	 * products would go down by 1 from the product inventory.
	 * 
	 * @param userid
	 * @return
	 */
	public static CartAPIResponse checkout(String userid) {
		// Get user's cart
		Cart cart = mCarts.get(userid);

		if (cart == null)
			return new CartAPIResponse(403, "Cart unavailable. Did you login?");

		// Iterate over each product in cart
		Iterator<Integer> cartItems = cart.getProducts().keySet().iterator();
		while (cartItems.hasNext()) {
			Product origProduct = mInventory.get(cartItems.next());

			// Quantity checks
			if (origProduct.getQuantity() <= 0)
				return new CartAPIResponse(403, "Insufficient stock for productid : " + origProduct.getId());

			// Remove the product from cart and decrease inventory quantity
			origProduct.setQuantity(origProduct.getQuantity() - 1);
			cart.removeProduct(origProduct.getId());
		}
		return new CartAPIResponse(200, "success!");
	}

}

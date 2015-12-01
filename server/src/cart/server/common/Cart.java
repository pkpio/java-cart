package cart.server.common;

import java.util.HashMap;

import cart.common.model.Product;

/**
 * Model for shopping cart of a user as maintained by the server
 * 
 * @author praveen
 *
 */
public class Cart {
	HashMap<Integer, Product> mProducts;

	public Cart() {
		mProducts = new HashMap<Integer, Product>();
	}

	public HashMap<Integer, Product> getProducts() {
		return mProducts;
	}

	public void setProducts(HashMap<Integer, Product> mProducts) {
		this.mProducts = mProducts;
	}

	public void addProduct(Product product) {
		mProducts.put(product.getId(), product);
	}

	public void removeProduct(int productid) {
		mProducts.remove(productid);
	}

}

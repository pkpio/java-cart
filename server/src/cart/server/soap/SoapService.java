package cart.server.soap;

import java.util.ArrayList;

import javax.jws.WebService;

import cart.common.model.CartAPIResponse;
import cart.common.model.Product;
import cart.server.common.WebServiceCommon;

@WebService(endpointInterface = "cart.server.soap.SoapInterface")
public class SoapService implements SoapInterface {

	@Override
	public CartAPIResponse login(String userid) {
		return WebServiceCommon.login(userid);
	}

	@Override
	public CartAPIResponse logout(String userid) {
		return WebServiceCommon.logout(userid);
	}

	@Override
	public ArrayList<Product> listProducts() {
		return WebServiceCommon.listProducts();
	}

	@Override
	public ArrayList<Product> addToCart(int productid, String userid) {
		return WebServiceCommon.addToCart(productid, userid);
	}

	@Override
	public ArrayList<Product> removeFromCart(int productid, String userid) {
		return WebServiceCommon.removeFromCart(productid, userid);
	}

	@Override
	public ArrayList<Product> listCart(String userid) {
		return WebServiceCommon.listCart(userid);
	}

	@Override
	public CartAPIResponse checkout(String userid) {
		return WebServiceCommon.checkout(userid);
	}

}

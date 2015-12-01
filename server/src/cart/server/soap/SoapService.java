package cart.server.soap;

import javax.jws.WebService;

import cart.server.common.WebServiceCommon;

@WebService(endpointInterface = "cart.server.soap.SoapInterface")
public class SoapService implements SoapInterface {

	@Override
	public String login() {
		return WebServiceCommon.login();
	}

	@Override
	public String logout(String userid) {
		return WebServiceCommon.logout(userid);
	}

	@Override
	public String listProducts() {
		return WebServiceCommon.listProducts();
	}

	@Override
	public String addToCart(int productid, String userid) {
		return WebServiceCommon.addToCart(productid, userid);
	}

	@Override
	public String listCart(String userid) {
		return WebServiceCommon.listCart(userid);
	}

	@Override
	public String checkout(String userid) {
		return WebServiceCommon.checkout(userid);
	}

}

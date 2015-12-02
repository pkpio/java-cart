package cart.server.soap;

import javax.jws.WebService;

import com.google.gson.Gson;

import cart.server.common.WebServiceCommon;

@WebService(endpointInterface = "cart.server.soap.SoapInterface")
public class SoapService implements SoapInterface {

	@Override
	public String login(String userid) {
		return new Gson().toJson(WebServiceCommon.login(userid));
	}

	@Override
	public String logout(String userid) {
		return new Gson().toJson(WebServiceCommon.logout(userid));
	}

	@Override
	public String listProducts() {
		return new Gson().toJson(WebServiceCommon.listProducts());
	}

	@Override
	public String addToCart(int productid, String userid) {
		return new Gson().toJson(WebServiceCommon.addToCart(productid, userid));
	}

	@Override
	public String removeFromCart(int productid, String userid) {
		return new Gson().toJson(WebServiceCommon.removeFromCart(productid, userid));
	}

	@Override
	public String listCart(String userid) {
		return new Gson().toJson(WebServiceCommon.listCart(userid));
	}

	@Override
	public String checkout(String userid) {
		return new Gson().toJson(WebServiceCommon.checkout(userid));
	}

}

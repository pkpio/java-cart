package client.control;

import cart.server.soap.SoapInterface;
import cart.server.soap.SoapServiceService;

public class SoapCtrl implements APICommonCtrl {
	SoapInterface mSoapInterface;

	public SoapCtrl() {
		SoapServiceService soapService = new SoapServiceService();
		mSoapInterface = soapService.getSoapServicePort();
	}

	public String login(String userid) {
		return mSoapInterface.login(userid);
	}

	public String logout(String userid) {
		return mSoapInterface.logout(userid);
	}

	public String listProducts() {
		return mSoapInterface.listProducts();
	}

	public String addToCart(String userid, int productid) {
		return mSoapInterface.addToCart(productid, userid);
	}

	public String removeFromCart(String userid, int productid) {
		return mSoapInterface.removeFromCart(productid, userid);
	}

	public String listCart(String userid) {
		return mSoapInterface.listCart(userid);
	}

	public String checkout(String userid) {
		return mSoapInterface.checkout(userid);
	}

}

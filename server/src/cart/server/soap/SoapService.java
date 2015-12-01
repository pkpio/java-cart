package cart.server.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "cart.server.soap.SoapInterface")
public class SoapService implements SoapInterface {

	@Override
	public String login() {
		return "User login!";
	}

	@Override
	public String logout(int userid) {
		return "User lgout for userid : " + userid;
	}

	@Override
	public String listProducts() {
		return "Product list";
	}

	@Override
	public String addToCart(int productid, int userid) {
		return "Product : " + productid + " userid : " + userid;
	}

	@Override
	public String listCart(int userid) {
		return "Cartlisting for userid : " + userid;
	}

	@Override
	public String checkout(int userid) {
		return "Cart checkout for userid : " + userid;
	}

}

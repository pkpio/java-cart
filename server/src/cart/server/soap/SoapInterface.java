package cart.server.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SoapInterface {

	@WebMethod
	String login(String userid);

	@WebMethod
	String logout(String userid);

	@WebMethod
	String listProducts();

	@WebMethod
	String addToCart(int productid, String userid);

	@WebMethod
	String removeFromCart(int productid, String userid);

	@WebMethod
	String listCart(String userid);

	@WebMethod
	String checkout(String userid);

}

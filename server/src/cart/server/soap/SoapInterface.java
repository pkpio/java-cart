package cart.server.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SoapInterface {

	@WebMethod
	String login();

	@WebMethod
	String logout(int userid);

	@WebMethod
	String listProducts();

	@WebMethod
	String addToCart(int productid, int userid);

	@WebMethod
	String listCart(int userid);

	@WebMethod
	String checkout(int userid);

}

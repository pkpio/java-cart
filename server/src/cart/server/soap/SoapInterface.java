package cart.server.soap;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import cart.common.model.CartAPIResponse;
import cart.common.model.Product;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SoapInterface {

	@WebMethod
	CartAPIResponse login(String userid);

	@WebMethod
	CartAPIResponse logout(String userid);

	@WebMethod
	ArrayList<Product> listProducts();

	@WebMethod
	ArrayList<Product> addToCart(int productid, String userid);

	@WebMethod
	ArrayList<Product> removeFromCart(int productid, String userid);

	@WebMethod
	ArrayList<Product> listCart(String userid);

	@WebMethod
	CartAPIResponse checkout(String userid);

}

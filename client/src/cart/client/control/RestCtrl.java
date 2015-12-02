package cart.client.control;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import cart.client.common.Constant;

/**
 * REST API controller that communicates with server using REST calls
 * 
 * @author praveen
 *
 */
public class RestCtrl implements APICommonCtrl {
	WebResource mRestInterface;

	public RestCtrl() {
		Client client = Client.create(new DefaultClientConfig());
		mRestInterface = client.resource(Constant.API_REST_URI);
	}

	public String login(String userid) {
		WebResource res = mRestInterface.path("/user/login").queryParam("userid", userid);
		return performRestOperation(res);
	}

	public String logout(String userid) {
		WebResource res = mRestInterface.path("/user/logout").queryParam("userid", userid);
		return performRestOperation(res);
	}

	public String listProducts() {
		WebResource res = mRestInterface.path("/product/list");
		return performRestOperation(res);
	}

	public String addToCart(String userid, int productid) {
		WebResource res = mRestInterface.path("/product/" + productid + "/addToCart").queryParam("userid", userid);
		return performRestOperation(res);
	}

	public String removeFromCart(String userid, int productid) {
		WebResource res = mRestInterface.path("/product/" + productid + "/removeFromCart").queryParam("userid", userid);
		return performRestOperation(res);
	}

	public String listCart(String userid) {
		WebResource res = mRestInterface.path("/cart/list").queryParam("userid", userid);
		return performRestOperation(res);
	}

	public String checkout(String userid) {
		WebResource res = mRestInterface.path("/cart/checkout").queryParam("userid", userid);
		return performRestOperation(res);
	}

	private String performRestOperation(WebResource resource) {
		return resource.accept(MediaType.TEXT_PLAIN).get(String.class).toString();
	}

}

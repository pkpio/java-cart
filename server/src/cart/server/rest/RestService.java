package cart.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import cart.server.common.WebServiceCommon;

@Path("/")
public class RestService {

	@GET
	@Path("/user/login")
	public String login(@QueryParam("userid") String userid) {
		return new Gson().toJson(WebServiceCommon.login(userid));
	}

	@GET
	@Path("/user/logout")
	public String logout(@QueryParam("userid") String userid) {
		return new Gson().toJson(WebServiceCommon.logout(userid));
	}

	@GET
	@Path("/product/list")
	public String listProducts() {
		return new Gson().toJson(WebServiceCommon.listProducts());
	}

	@GET
	@Path("/product/{productid}/addToCart")
	public String addToCart(@PathParam("productid") int productid, @QueryParam("userid") String userid) {
		return new Gson().toJson(WebServiceCommon.addToCart(productid, userid));
	}

	@GET
	@Path("/product/{productid}/removeFromCart")
	public String removeFromCart(@PathParam("productid") int productid, @QueryParam("userid") String userid) {
		return new Gson().toJson(WebServiceCommon.removeFromCart(productid, userid));
	}

	@GET
	@Path("/cart/list")
	public String listCart(@QueryParam("userid") String userid) {
		return new Gson().toJson(WebServiceCommon.listCart(userid));
	}

	@GET
	@Path("/cart/checkout")
	public String checkout(@QueryParam("userid") String userid) {
		return new Gson().toJson(WebServiceCommon.checkout(userid));
	}

}

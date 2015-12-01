package cart.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/")
public class RestService {

	@GET
	@Path("/user/login")
	public String login() {
		return "User login!";
	}

	@GET
	@Path("/user/logout")
	public String logout(@QueryParam("userid") int userid) {
		return "User lgout for userid : " + userid;
	}

	@GET
	@Path("/product/list")
	public String listProducts() {
		return "Product list";
	}

	@GET
	@Path("/product/{productid}/addToCart")
	public String addToCart(@PathParam("productid") int productid, @QueryParam("userid") int userid) {
		return "Product : " + productid + " userid : " + userid;
	}

	@GET
	@Path("/cart/list")
	public String listCart(@QueryParam("userid") int userid) {
		return "Cartlisting for userid : " + userid;
	}

	@GET
	@Path("/cart/checkout")
	public String checkout(@QueryParam("userid") int userid) {
		return "Cart checkout for userid : " + userid;
	}

}

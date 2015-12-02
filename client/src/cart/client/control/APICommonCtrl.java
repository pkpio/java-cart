package cart.client.control;

/**
 * This is a common interface to be implemented by all the API controllers
 * 
 * @author praveen
 *
 */
public interface APICommonCtrl {

	public String login(String userid);

	public String logout(String userid);

	public String listProducts();

	public String addToCart(String userid, int productid);

	public String removeFromCart(String userid, int productid);

	public String listCart(String userid);

	public String checkout(String userid);

}

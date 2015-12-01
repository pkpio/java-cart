package cart.common.model;

/**
 * Generic response model for the API
 * 
 * @author praveen
 */
public class CartAPIResponse {
	int status;
	String message;

	public CartAPIResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}

package cart.client.common;


public class Constant {

	public static final String API_REST_URI = "http://localhost:8080/rest";
	public static final String API_SOAP_URI = "http://localhost:8090/soap";
	
	/**
	 * Maximum width of the canvas where the game can be played
	 */
	public static final int CANVAS_WIDTH = 800;
	/**
	 * Maximum height of the canvas where the game can be played
	 */
	public static final int CANVAS_HEIGHT = 600;

	// Offsets to avoid fly positioning outside canvas
	/**
	 * Fly position min offset in x-directions
	 */
	public static final int OFFSET_X = 60;
	/**
	 * Fly position min offset in y-directions
	 */
	public static final int OFFSET_Y = 100;

}
package cart.client.ui;

import java.awt.GridLayout;

import cart.client.control.ClientCtrl;
/**
 *  Widget used to render product details to user
 * @author Ram
 *
 */
public class ProductDetailsPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;

	private javax.swing.JButton addButton;
	private javax.swing.JLabel price;
	private javax.swing.JLabel productName;
	private javax.swing.JTextField quantity;

	ClientCtrl controlobject;
	int productid;

	public ProductDetailsPanel(ClientCtrl controlobject) {
		this.controlobject = controlobject;

	}

	/**
	 * Creates new form ProductDetailsPanel
	 */
	public ProductDetailsPanel(int productId, String productName, int price, int availableQuantity,
			ClientCtrl ctrlObject) {
		this.controlobject = ctrlObject;
		this.productid = productId;
		initComponents(productId, productName, price, availableQuantity);

	}

	private void initComponents(int id, String name, int priceOfTheProduct, int stock) {

		productName = new javax.swing.JLabel();
		price = new javax.swing.JLabel();
		quantity = new javax.swing.JTextField();
		addButton = new javax.swing.JButton();

		productName.setText(name);

		price.setText(priceOfTheProduct + "");

		quantity.setText(stock + "");
		quantity.setEnabled(false);

		addButton.setText("add");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});

		GridLayout layout = new GridLayout(1, 1, 60, 10);
		this.setLayout(layout);
		this.add(productName);
		this.add(price);
		this.add(quantity);
		this.add(addButton);

	}

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controlobject.addToCart(productid);
		System.out.println("added to cart");
		controlobject.getClientView().updatecart();

	}

}

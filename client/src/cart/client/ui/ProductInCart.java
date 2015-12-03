package cart.client.ui;

import java.awt.Color;
import java.awt.GridLayout;

import cart.client.control.ClientCtrl;
import cart.common.model.Product;

/**
 * A widget with 2 labels and a delete button used as part of cartListPanel to
 * show products available in the cart
 *
 * @author Ram
 */
public class ProductInCart extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form NewJPanel
	 * 
	 * @param controlObject
	 */
	ClientCtrl controlObject;
	int productId;

	public ProductInCart(Product product, ClientCtrl controlObject) {

		this.controlObject = controlObject;
		productId = product.getId();
		initComponents(product.getTitle(), product.getPrice());
	}

	
	@SuppressWarnings("unchecked")
	private void initComponents(String productName, int price) {

		productNameLabel = new javax.swing.JLabel();
		productPrice = new javax.swing.JLabel();
		this.setBackground(Color.white);

		productNameLabel.setText(productName);
		productPrice.setText("$" + price);
		removeProduct = new javax.swing.JButton();
		removeProduct.setIcon(new javax.swing.ImageIcon("/Users/Ram/git/java-cart-new/res/editing-delete-icon.png")); // NOI18N

		removeProduct.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		GridLayout layout = new GridLayout(1, 3, 5, 4);
		this.setLayout(layout);
		this.add(productNameLabel);
		this.add(productPrice);
		this.add(removeProduct);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		controlObject.removeFromCart(productId);
		controlObject.getClientView().updatecart();
	}

	
	private javax.swing.JButton removeProduct;
	private javax.swing.JLabel productNameLabel;
	private javax.swing.JLabel productPrice;

}

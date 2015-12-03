package cart.client.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import cart.client.common.Constant;
import cart.client.control.ClientCtrl;
import cart.common.model.CartAPIResponse;
import cart.common.model.Product;

/**
 * 
 * 
 * 
 * @author Ram
 */
public class ClientView {

	private JFrame javaCart;
	private JPanel mainPanel;
	private JPanel loginPanel;
	private GroupLayout groupLayout;
	private JLabel customerName;
	private JButton logIn;
	private JTextField customerNameTextField;
	Dimension screenSize;
	String name = "";
	ClientCtrl controlObject;
	private javax.swing.JLabel cartDetailsLabel;
	private javax.swing.JPanel cartDetailsPanel;
	private javax.swing.JButton checkOutButton;
	private javax.swing.JPanel headerPanel;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel productListPanel;
	private javax.swing.JLabel priceHeadeLabel;
	private javax.swing.JLabel productNameHeaderLabel;
	private javax.swing.JButton refreshButton;
	private javax.swing.JLabel serverResponceLabel;
	private javax.swing.JTextArea serverResponseTextArea;
	private javax.swing.JLabel shoppingTitleLabel;
	private javax.swing.JLabel stockHeaderLabel;
	private javax.swing.JLabel welcomeLabel;
	private javax.swing.JPanel welcomePanel;
	private String webServType;

	public ClientView(ClientCtrl controlObject, String webServType) throws Exception {
		this.webServType = webServType;
		initGUI();
		this.controlObject = controlObject;
		controlObject.setClientView(this);
	}

	private void initGUI() throws Exception {
		javaCart = new JFrame("JavaCart " + webServType);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		javaCart.setBounds(0, 0, 1024, 768);
		int xCoordinate, yCoordinate;
		xCoordinate = (int) javaCart.getSize().getWidth() / 2;
		yCoordinate = (int) javaCart.getSize().getHeight() / 2;
		loginPanel = new JPanel();
		groupLayout = new GroupLayout(javaCart.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(100, Short.MAX_VALUE)
						.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
						.addGap(468)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(348, Short.MAX_VALUE)
						.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(282)));

		customerName = new JLabel("Enter your name");
		customerName.setHorizontalAlignment(SwingConstants.LEFT);

		customerName.setLocation(xCoordinate - 500, yCoordinate - 5);
		loginPanel.add(customerName);

		customerNameTextField = new JTextField();
		customerNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		customerNameTextField.setColumns(10);
		customerNameTextField.setLocation(xCoordinate + (int) (customerName.getSize().getWidth()), yCoordinate - 5);
		loginPanel.add(customerNameTextField);

		logIn = new JButton("Shop>>");
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Collect playerName
				name = customerNameTextField.getText();
				if (name.length() != 0)
					try {
						controlObject.login(name);
						startCart();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});

		javaCart.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		loginPanel.add(logIn);
		javaCart.getContentPane().setLayout(groupLayout);
		javaCart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		javaCart.setVisible(true);

	}

	protected void startCart() {
		customerName.setVisible(false);
		customerNameTextField.setVisible(false);
		logIn.setVisible(false);
		javaCart.setBounds(0, 0, 800, 400);
		javaCart.validate();
		javaCart.setResizable(false);
		javaCart.pack();
		javaCart.getContentPane().remove(loginPanel);
		mainPanel = new JPanel();

		headerPanel = new javax.swing.JPanel();
		shoppingTitleLabel = new javax.swing.JLabel();
		productNameHeaderLabel = new javax.swing.JLabel();
		priceHeadeLabel = new javax.swing.JLabel();
		stockHeaderLabel = new javax.swing.JLabel();
		welcomePanel = new javax.swing.JPanel();
		welcomeLabel = new javax.swing.JLabel();
		cartDetailsLabel = new javax.swing.JLabel();
		cartDetailsPanel = new javax.swing.JPanel();
		checkOutButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		serverResponseTextArea = new javax.swing.JTextArea();
		refreshButton = new javax.swing.JButton();
		serverResponceLabel = new javax.swing.JLabel();
		productListPanel = new javax.swing.JPanel();

		shoppingTitleLabel.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
		shoppingTitleLabel.setText("Shopping");

		productNameHeaderLabel.setText("Product Name");

		priceHeadeLabel.setText("Price");

		stockHeaderLabel.setText("Stock");
		addProducts();
		GridLayout headerPanelLayout = new GridLayout(1, 1, 60, 10);
		headerPanel.setLayout(headerPanelLayout);
		headerPanel.add(productNameHeaderLabel);
		headerPanel.add(priceHeadeLabel);
		headerPanel.add(stockHeaderLabel);

		welcomeLabel.setText("Welcome " + name);
		;

		cartDetailsLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		cartDetailsLabel.setText("Cart Details");

		checkOutButton.setText("Checkout");
		checkOutButton.setActionCommand("checkOutButton");
		checkOutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkOutButtonActionPerformed(evt);
			}
		});

		cartDetailsPanel.setLayout(new GridLayout(10, 1, 5, 5));
		javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
		welcomePanel.setLayout(welcomePanelLayout);
		welcomePanelLayout.setHorizontalGroup(welcomePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(welcomePanelLayout.createSequentialGroup()
						.addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(welcomePanelLayout.createSequentialGroup().addGap(24, 24, 24)
										.addGroup(welcomePanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(cartDetailsLabel).addComponent(welcomeLabel)))
								.addGroup(welcomePanelLayout.createSequentialGroup().addContainerGap().addComponent(
										cartDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(welcomePanelLayout.createSequentialGroup()
						.addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(welcomePanelLayout.createSequentialGroup().addGap(24, 24, 24))
								.addGroup(welcomePanelLayout.createSequentialGroup()))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		welcomePanelLayout
				.setVerticalGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(welcomePanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(welcomeLabel).addGap(98, 98, 98).addComponent(cartDetailsLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(welcomePanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cartDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)));

		serverResponseTextArea.setColumns(10);
		serverResponseTextArea.setRows(5);
		jScrollPane1.setViewportView(serverResponseTextArea);

		refreshButton.setText("Refresh");
		refreshButton.setActionCommand("refreshButton");
		refreshButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				refreshButtonActionPerformed(evt);
			}
		});

		serverResponceLabel.setText("Server Response");

		javax.swing.GroupLayout labelHeaderProductListLayout = new javax.swing.GroupLayout(productListPanel);
		productListPanel.setLayout(new GridLayout(10, 1));
		labelHeaderProductListLayout.setHorizontalGroup(labelHeaderProductListLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 499, Short.MAX_VALUE));
		labelHeaderProductListLayout.setVerticalGroup(labelHeaderProductListLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 297, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(6, 6, 6)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(serverResponceLabel).addComponent(headerPanel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addComponent(refreshButton)
																.addGap(25, 25, 25))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addComponent(checkOutButton)
																.addGap(18, 18, 18))))))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(productListPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)))
				.addComponent(welcomePanel, 250, 250, 250).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(productListPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(275, 275, 275).addComponent(serverResponceLabel)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(checkOutButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(refreshButton))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.CENTER).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, Constant.CANVAS_WIDTH,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.CENTER).addComponent(mainPanel,
								Alignment.LEADING, GroupLayout.DEFAULT_SIZE, Constant.CANVAS_HEIGHT, Short.MAX_VALUE))
				.addContainerGap()));

		javaCart.getContentPane().add(mainPanel);
		javaCart.getContentPane().setLayout(groupLayout);
		// gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		javaCart.setVisible(true);
		javaCart.addWindowListener(new WindowAdapter() {
			// WINDOW_CLOSING event handler
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// You can still stop closing if you want to
				int res = JOptionPane.showConfirmDialog(javaCart, "Are you sure you want to close?", "Close?",
						JOptionPane.YES_NO_OPTION);
				if (res == 0) {
					javaCart.setVisible(false);
					javaCart.dispose();
					controlObject.logout();
					System.exit(0);
				}
			}

			// WINDOW_CLOSED event handler
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
			}
		});

		javaCart.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainPanel.setLayout(null);

	}

	/**
	 * method to render product list to UI
	 */
	public void addProducts() {
		Product[] products = controlObject.listProducts();
		productListPanel.removeAll();
		for (Product product : products) {
			if (product.getQuantity() > 0)
				productListPanel.add(new ProductDetailsPanel(product.getId(), product.getTitle(), product.getPrice(),
						product.getQuantity(), controlObject));
		}
		productListPanel.revalidate();
		productListPanel.setVisible(true);
		javaCart.repaint();

	}

	/**
	 * this method will be invoked upon checkout ,removeFromcart and addToCart
	 * actions
	 * 
	 */
	public void updatecart() {
		Product[] products = controlObject.listCart();
		cartDetailsPanel.removeAll();
		for (Product product : products)
			cartDetailsPanel.add(new ProductInCart(product, controlObject));
		cartDetailsPanel.revalidate();
		javaCart.repaint();

	}

	/**
	 * product checkout and UI refresh
	 * 
	 * @param evt
	 */
	private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (controlObject.listCart().length == 0) {
			JOptionPane.showMessageDialog(javaCart, "Cart is empty", "Error", JOptionPane.ERROR_MESSAGE);
			updatecart();
		} else {
			int res = JOptionPane.showConfirmDialog(javaCart, "Are you sure you want to proceed to checkout?",
					"checkout",

					JOptionPane.YES_NO_OPTION);
			if (res == 0) {
				CartAPIResponse response = controlObject.checkout();
				serverResponseTextArea.setText(response.getMessage());
				addProducts();
				updatecart();
			}
		}
	}

	/**
	 * Method to refresh product list upon clicking refresh button
	 * 
	 * @param evt
	 */
	private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
		addProducts();
	}

	/**
	 * Methoud to update server response on the client UI
	 * 
	 * @param message
	 */
	void updateServerResponse(String message) {
		serverResponseTextArea.setText(message);
		mainPanel.revalidate();
	}
}

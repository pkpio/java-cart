package cart.client.ui;

import java.awt.Dimension;
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

import cart.client.common.Constant;
import cart.client.control.ClientCtrl;
import cart.common.model.Product;

import javax.swing.SwingConstants;

/**
 * The client GUI logic appears here
 * 
 * 
 * @author Ram
 */
public class ClientView {

	private JFrame javaCart;
	private JPanel mainPanel;
	private JPanel loginPanel;
	private JPanel eastPanel;
	private GroupLayout groupLayout;
	private JLabel customerName;
	private JButton logIn;
	private JTextField customerNameTextField;
	Dimension screenSize;
	String name = "";
	ClientCtrl controlObject;

	public ClientView(ClientCtrl controlObject) throws Exception {
		initGUI();
		this.controlObject = controlObject;
	}

	private void initGUI() throws Exception {
		javaCart = new JFrame("JavaCart");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		javaCart.setBounds(0, 0, 1024, 768);
		int xCoordinate, yCoordinate;
		xCoordinate = (int) javaCart.getSize().getWidth() / 2;
		yCoordinate = (int) javaCart.getSize().getHeight() / 2;
		loginPanel = new JPanel();
		groupLayout = new GroupLayout(javaCart.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(577, Short.MAX_VALUE)
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
		javaCart.getContentPane().remove(loginPanel);
		mainPanel = new JPanel();
		addProducts();

		eastPanel = new JPanel();
		setComplexPanel();// new JPanel();

		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.CENTER).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, Constant.CANVAS_WIDTH,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(eastPanel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.CENTER).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(eastPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, Constant.CANVAS_HEIGHT,
								Short.MAX_VALUE)
						.addComponent(mainPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, Constant.CANVAS_HEIGHT,
								Short.MAX_VALUE))
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

	private void addProducts() {
		Product[] products = controlObject.listProducts();
		mainPanel.add(new ProductDetailsPanel(controlObject));
		for (Product product : products)
			mainPanel.add(new ProductDetailsPanel(product.getId(), product.getTitle(), product.getPrice(),
					product.getQuantity(), controlObject));
		mainPanel.setVisible(true);

	}

	private javax.swing.JButton checkOutButton;
	private javax.swing.JLabel welcomeLabel;

	void setComplexPanel() {
		checkOutButton = new javax.swing.JButton();
		welcomeLabel = new javax.swing.JLabel();

		checkOutButton.setText("Check Out");
		checkOutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkOut(evt);
			}
		});

		welcomeLabel.setFont(new java.awt.Font("YuMincho +36p Kana", 3, 14)); // NOI18N
		welcomeLabel.setText("Welcome " + name);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(eastPanel);
		eastPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(31, 31, 31).addComponent(welcomeLabel)
										.addGap(10, 10, 10))
						.addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addComponent(checkOutButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(0, 48, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(63, 63, 63)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(welcomeLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
						.addComponent(checkOutButton).addGap(57, 57, 57)));
		javaCart.pack();
		javaCart.setResizable(false);

	}

	private void checkOut(java.awt.event.ActionEvent evt) {
		int res = JOptionPane.showConfirmDialog(javaCart, "Are you sure you want to proceed to checkout?", "checkout",
				JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			mainPanel.repaint();
			mainPanel.removeAll();
			mainPanel.setVisible(false);
			controlObject.checkout();
		}
	}

}

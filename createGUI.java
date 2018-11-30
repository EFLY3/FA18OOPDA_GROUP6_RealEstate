package agency;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * createGUI launching pad for the Realty program Asks the user one question to
 * decide which direction the program will go
 * 
 * @version 2018.11.29
 * @author E.Fliegel 
 * -Edited by: D.Pimentel
 */
public class createGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel askUser;
	JLabel question;
	JButton buyerButton, sellerButton;

	public createGUI() {
		super("Buyer or Seller");
		makeQuestionFrame();
	}

	/**
	 * Creates GUI layout
	 */
	public void makeQuestionFrame() {
		this.setLayout(new BorderLayout());
		setTitle("Buyer or Seller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		question = new JLabel("Are you buying or selling?");
		buyerButton = new JButton("Buying");
		buyerButton.addActionListener(e -> createBuyerGUI());
		sellerButton = new JButton("Selling");
		sellerButton.addActionListener(e -> createSellerGUI());

		askUser = new JPanel(new FlowLayout());
		askUser.add(question);
		askUser.add(buyerButton);
		askUser.add(sellerButton);

		this.getContentPane().add(askUser, BorderLayout.CENTER);
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));

		pack();
		setVisible(true);
	}

	/**
	 * Creates a new frame with options to buy a property
	 */
	public void createBuyerGUI() {
		buyerGUI buyer = new buyerGUI();
		buyer.makeBuyerGUI();
		this.setVisible(false);
	}

	/**
	 * Creates a new frame with options to sell a property
	 */
	public void createSellerGUI() {
		sellerGUI seller = new sellerGUI();
		seller.makeSellerGUI();
		this.setVisible(false);
	}
}

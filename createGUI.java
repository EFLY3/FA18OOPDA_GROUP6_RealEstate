/**
 *		createGUI
 *	launching pad for the Realty program
 *	asks one question to deside which direction you will gp
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class createGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JPanel askUser;
	JLabel question;
	JButton buyerButton, sellerButton;
	
	public createGUI()
	{
		super("Buyer or Seller");
		makeQuestionFrame();
	}
	public void makeQuestionFrame()
	{
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
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder( 5, 5, 5, 5));
		
		pack();
		setVisible(true);
	}
	
	public void createBuyerGUI()
	{
		buyerGUI buyer = new buyerGUI();
		buyer.makeBuyerGUI();
		this.setVisible(false);
	}
	public void createSellerGUI()
	{
		sellerGUI seller = new sellerGUI();
		seller.makeSellerGUI();
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		new createGUI();
	}
}

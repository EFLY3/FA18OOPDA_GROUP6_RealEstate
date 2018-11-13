import javax.swing.*;

public class createGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JTextArea question;
	JButton buyerButton, sellerButton;
	
	public createGUI()
	{
		super("Buyer or Seller");
		makeQuestionFrame();
	}
	public void makeQuestionFrame()
	{
		setTitle("Buyer or Seller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		question = new JTextArea();
		question.setText("Are you buying or selling?");
		buyerButton = new JButton("Buying");
		buyerButton.addActionListener(e -> createBuyerGUI());
		sellerButton = new JButton("Selling");
		sellerButton.addActionListener(e -> createSellerGUI());
		
		this.add(question);
		this.add(buyerButton);
		this.add(sellerButton);
		
		
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
}

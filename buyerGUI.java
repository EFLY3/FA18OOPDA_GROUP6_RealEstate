import java.awt.*;
//import java.io.*;
import javax.swing.*;

public class buyerGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	//File f1 = new File("propertiesforsale.dat");
	//File f2 = new File("soldproperties.dat");
	//ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream (f1));
	//ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));

	searchPanel search;
	listPane list;
	JOptionPane purchaseConfirm;
	
	public buyerGUI() {
		search = new searchPanel(list);
		list = new listPane(search);
		
		this.setLayout(new BorderLayout());
		this.add(search, BorderLayout.WEST);
		this.add(list, BorderLayout.EAST);
	}
	
	/* public void filterList() - might move these methods here instead for simplification
	{
		
	}
		
	public void makePurchase()
	{
		
	} */
		
}


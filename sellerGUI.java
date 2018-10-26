import java.awt.GridLayout;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.*;

public class sellerGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	File f1 = new File("propertiesforsale.dat");
    //ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream (f1));
    //ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));
	
	JOptionPane buyerOrSellerMessage, propertyInfo, purchaseConfirm, listConfirm;
	JPanel searchPanel;
	JLabel typeLabel = new JLabel("Property Type: ");
	JLabel floorLabel = new JLabel("Number of Floors: "); 
	JLabel roomLabel = new JLabel("Number of Rooms: ");
	JLabel poolLabel = new JLabel("Pool: ");
	JLabel fireplaceLabel = new JLabel("Fireplace: ");
	JLabel garageLabel = new JLabel("Garage: ");
	JLabel securityLabel = new JLabel("Security System: ");
	JComboBox<Property> typeSelect = new JComboBox<>();
	JTextField floorInput, roomInput;
	JRadioButton poolButton, fireplaceButton, garageButton, securityButton;
	
	public sellerGUI() 
	{
		this.setLayout(new GridLayout(0,2));
		
		this.add(typeLabel);
		this.add(typeSelect);
		this.add(floorLabel);
		this.add(floorInput);
		this.add(roomLabel);
		this.add(roomInput);
		this.add(poolLabel);
		this.add(poolButton);
		this.add(garageLabel);
		this.add(garageButton);
		this.add(fireplaceLabel);
		this.add(fireplaceButton);
		this.add(securityLabel);
		this.add(securityButton);
	}
	private void makeProperty()
	{
		//create a property using the input from the user
	}
}

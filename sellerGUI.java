import java.awt.*;
import java.io.*;
import javax.swing.*;

public class sellerGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	File f = new File("propertiesforsale.dat");
    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream (f));
	
	JOptionPane listConfirm;
	JLabel typeLabel, floorLabel,roomLabel, poolLabel, fireplaceLabel, garageLabel, securityLabel;
	JComboBox<String> typeSelect;
	JTextField floorInput, roomInput;
	JRadioButton poolButton, fireplaceButton, garageButton, securityButton;
	boolean hasPool, hasSecurity, hasFireplace, hasGarage;
	int rooms, floors;
	
	public sellerGUI() 
	{
		super("sellerGUI");
		makeSellerGUI();
	}
	public void makeSellerGUI()
	{
		listConfirm = new JOptionPane();
		typeLabel = new JLabel("Property type: ");
		floorLabel = new JLabel("Number of Floors: ");
		roomLabel = new JLabel("Number of Rooms: ");
		securityLabel = new JLabel("Security System: ");
		fireplaceLabel = new JLabel("Fireplace: ");
		garageLabel = new JLabel("Garage: ");
		poolLabel = new JLabel("Pool: ");
		typeSelect = new JComboBox<>();
		floorInput = new JTextField();
		roomInput = new JTextField();
		poolButton = new JRadioButton();
		garageButton = new JRadioButton();
		fireplaceButton = new JRadioButton();
		securityButton = new JRadioButton();
		hasPool = hasSecurity = hasGarage = hasFireplace = false;
		rooms = floors = 0;
		
		this.setTitle("List Property for Sale");
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		typeSelect.addItem("Apartment");
		typeSelect.addItem("Bungalow");
		typeSelect.addItem("Business");
		typeSelect.addItem("Cape Cod");
		typeSelect.addItem("Colonial");
		typeSelect.addItem("Commercial");
		typeSelect.addItem("Condo");
		typeSelect.addItem("Ranch");
		typeSelect.addItem("TownHouse");
		typeSelect.addItem("Victorian");
		
		pack(); setVisible(true);
	}
	private void makeProperty()
	{
		rooms = Integer.parseInt(roomInput.getText());
		floors = Integer.parseInt(floorInput.getText());
		if(securityButton.isSelected()) {hasSecurity = true;}
		if(fireplaceButton.isSelected()) {hasFireplace = true;}
		if(garageButton.isSelected()) {hasGarage = true;}
		if(poolButton.isSelected()) {hasPool = true;}
		
		Property toSell = new Property();
		toSell.setRooms(rooms);
		toSell.setFloors(floors);
		toSell.setSecurity(hasSecurity);
		toSell.setFireplace(hasFireplace);
		toSell.setGarage(hasGarage);
		toSell.setPool(hasPool);
		
		os.writeObject(toSell);
		os.close();
		listConfirm.showMessageDialog(null, "Congrats! You just listed a property for sale!");
		}
	}
}

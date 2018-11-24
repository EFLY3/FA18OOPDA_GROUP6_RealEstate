
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class sellerGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	//Property toSell;
	//Appraiser acme;
	JOptionPane listConfirm;
	JLabel typeLabel, sqftLabel, roomLabel, poolLabel, fireplaceLabel, garageLabel, securityLabel, bathLabel, yardLabel,
			builtLabel, addressLabel;
	JComboBox<String> typeSelect;
	JTextField sqftInput, roomInput, addressInput, bathInput, yardInput, builtInput;
	JRadioButton poolButton, fireplaceButton, garageButton, securityButton;
	boolean hasPool, hasSecurity, hasFireplace, hasGarage;
	int rooms, sqft, builtIn;
	double bath, yard;
	String address, type;
	JButton submit;
	Property toSell;

	JPanel set1;
	JPanel set2;
	JPanel set3;

	public sellerGUI() {
		super("sellerGUI");
		makeSellerGUI();
	}

	public void makeSellerGUI() {
		
		this.setTitle("List Property for Sale");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		listConfirm = new JOptionPane();

		addressLabel = new JLabel("Address: ");
		typeLabel = new JLabel("Property type: ");
		builtLabel = new JLabel("Built In: ");
		sqftLabel = new JLabel("Number of Square Footage: ");
		roomLabel = new JLabel("Number of Rooms: ");
		bathLabel = new JLabel("Number of Bathrooms: ");
		yardLabel = new JLabel("Size of Yard (in acres): ");
		securityLabel = new JLabel("Security System: ");
		fireplaceLabel = new JLabel("Fireplace: ");
		garageLabel = new JLabel("Garage: ");
		poolLabel = new JLabel("Pool: ");
		addressInput = new JTextField();
		typeSelect = new JComboBox<>();
		builtInput = new JTextField();
		sqftInput = new JTextField();
		roomInput = new JTextField();
		bathInput = new JTextField();
		yardInput = new JTextField();
		poolButton = new JRadioButton();
		garageButton = new JRadioButton();
		fireplaceButton = new JRadioButton();
		securityButton = new JRadioButton();
		hasPool = hasSecurity = hasGarage = hasFireplace = false;
		rooms = sqft = builtIn = 0;
		bath = yard = 0.0;

		submit = new JButton("Submit");
		submit.addActionListener(e -> makeProperty());

		
		set1();
		set2();
		set3();

		this.getContentPane().add(set1, BorderLayout.WEST);
		this.getContentPane().add(set2, BorderLayout.CENTER);
		this.getContentPane().add(set3, BorderLayout.EAST);
		this.getContentPane().add(submit, BorderLayout.SOUTH);

		typeSelect.addItem("Apartment");
		typeSelect.addItem("Bungalow");
		typeSelect.addItem("Cape Cod");
		typeSelect.addItem("Colonial");
		typeSelect.addItem("Commercial");
		typeSelect.addItem("Condo");
		typeSelect.addItem("Ranch");
		typeSelect.addItem("TownHouse");
		typeSelect.addItem("Victorian");

		pack();
		setVisible(true);
	}

	private void set1() {
		set1 = new JPanel();
		set1.setLayout(new GridLayout(4, 2));

		set1.add(addressLabel);
		set1.add(addressInput);
		set1.add(typeLabel);
		set1.add(typeSelect);
		set1.add(builtLabel);
		set1.add(builtInput);
		set1.add(sqftLabel);
		set1.add(sqftInput);
	}

	private void set2() {
		set2 = new JPanel();
		set2.setLayout(new GridLayout(4, 2));

		set2.add(roomLabel);
		set2.add(roomInput);

		set2.add(bathLabel);
		set2.add(bathInput);

		set2.add(yardLabel);
		set2.add(yardInput);
	}

	private void set3() {
		set3 = new JPanel();
		set3.setLayout(new GridLayout(4, 2));

		set3.add(poolLabel);
		set3.add(poolButton);

		set3.add(garageLabel);
		set3.add(garageButton);

		set3.add(fireplaceLabel);
		set3.add(fireplaceButton);

		set3.add(securityLabel);
		set3.add(securityButton);
	}

	//private class makeProperty implements ActionListener {

		//public void actionPerformed(ActionEvent e) {
public void makeProperty()
{
			address = addressInput.getText();
			type = typeSelect.getToolTipText();
			
			//The main issue was happening in this block
			
//			builtIn = Integer.parseInt(builtInput.getText());
//			rooms = Integer.parseInt(roomInput.getText());
//			sqft = Integer.parseInt(sqftInput.getText());
//			bath = Double.parseDouble(bathInput.getText());
//			yard = Double.parseDouble(yardInput.getText());
			
			// the input needed to be validated before parsing the string 
			// to avoid getting a numberFormatException
			
			String built = builtInput.getText();
	        if(built.matches("[0-9]+"))          
	            builtIn = Integer.parseInt(built);
			
	        String room = roomInput.getText();
	        if(room.matches("[0-9]+"))
	        	rooms = Integer.parseInt(room);
	       
	        String foot = sqftInput.getText();
	        if(foot.matches("[0-9]+"))
	        	sqft = Integer.parseInt(foot);
	        
	        String bathroom = bathInput.getText();
	        if(bathroom.matches("[0-9]+"))
	        	 bath = Double.parseDouble(foot);
			
	        String backyard = yardInput.getText();
	        if(backyard.matches("[0-9]+"))
	        	 yard = Double.parseDouble(foot);
	   
			
			if (securityButton.isSelected()) {
				hasSecurity = true;
			}
			if (fireplaceButton.isSelected()) {
				hasFireplace = true;
			}
			if (garageButton.isSelected()) {
				hasGarage = true;
			}
			if (poolButton.isSelected()) {
				hasPool = true;
			}
			
			if (typeSelect.getToolTipText() == "Commercial")
				{
						toSell = new Commercial();
				}
			else
			{
				toSell = new Residential();
			}

			toSell.setAddress(address);
			//I used a println to see if the values where being passed to the fields
			//But if you noticed the output is still null
			System.out.println("address: " + toSell.getAddress());
			
			toSell.setPropertyType(type);
			toSell.setBuiltIn(builtIn);
			toSell.setSquareFoot(sqft);
			toSell.setNumRooms(rooms);
			toSell.setNumBath(bath);
			toSell.setBackyard(yard);
			toSell.setHas_secSystem(hasSecurity);
			toSell.setHas_fireplace(hasFireplace);
			toSell.setGarage(hasGarage);
			toSell.setHas_pool(hasPool);

			Appraiser acme = new Appraiser();
			acme.calculatePropertyValue(sqft, yard, hasSecurity, hasPool, hasFireplace, hasGarage);

			toSell.setValue(acme.getPropertyValue());
			
			//Here are all the values that are being passed (all are still 0 and null)
			System.out.println(toSell.propWrite());

			try {
				acme.addPropertyToDatabase(toSell);
				

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null,
					"Congrats! You just listed a property for sale! We value the property at " + toSell.getValue());
		
	}}


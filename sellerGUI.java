
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * sellerGUI
 *
 * Accepts inputs from the user to create a property to be sold. The questions
 * appear one at a time, then generate a review sheet if the sheet is accepted
 * it prints out the property and tell you the appraised price
 * 
 * @version 2018.11.29
 * @author E.Fliegel
 * -Edited by R.Erskine and D.Pimentel
 */
public class sellerGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<String> typeSelect; // List of property types

	JPanel set1, set2, set3;

	boolean hasPool, hasSecurity, hasFireplace, hasGarage;
	int rooms, sqft, builtIn;
	double bath, yard;
	String address, type;
	JButton submit; // Submit information entered
	Property toSell; // To hold new property created

	public sellerGUI() {
		super("sellerGUI");

		hasPool = hasSecurity = hasFireplace = hasGarage = false;

		int r = 0;

		String[] possibleValues = { "Apartment", "Colonial", "Cape Cod", "Ranch", "Bungalow", "Victorian", "Townhouse",
				"Condo", "Commercial" };
	
		// Holds data to Populate property fields
		address = JOptionPane.showInputDialog("What is the Address?");
		type = (String) JOptionPane.showInputDialog(null, "What type of property is it?", "Choose One",
				JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
		builtIn = Integer.parseInt(JOptionPane.showInputDialog("When was the property built?"));
		sqft = Integer.parseInt(JOptionPane.showInputDialog("How many square feet is the property?"));
		rooms = Integer.parseInt(JOptionPane.showInputDialog("How many bedrooms are in the property?"));
		bath = Double.parseDouble(JOptionPane.showInputDialog("How many bathrooms are in the property?"));
		yard = Double.parseDouble(JOptionPane.showInputDialog("How much acreage does the property have?"));

		//Get values through JOptionPanes
		r = JOptionPane.showConfirmDialog(null, "Does the property have a pool?", "Choose One",
				JOptionPane.YES_NO_OPTION);
		if (r == 0) {
			hasPool = true;
		}

		r = JOptionPane.showConfirmDialog(null, "Does the property have a security system?", "Choose One",
				JOptionPane.YES_NO_OPTION);
		if (r == 0) {
			hasSecurity = true;
		}

		r = JOptionPane.showConfirmDialog(null, "Does the property have a fireplace?", "Choose One",
				JOptionPane.YES_NO_OPTION);
		if (r == 0) {
			hasFireplace = true;
		}

		r = JOptionPane.showConfirmDialog(null, "Does the property have a garage?", "Choose One",
				JOptionPane.YES_NO_OPTION);
		if (r == 0) {
			hasGarage = true;
		}

		makeSellerGUI();
	}

	/**
	 * Creates the frame's layout with three panels
	 */
	public void makeSellerGUI() {
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Review your Input");
		setLayout(new BorderLayout());

		set1();
		set2();
		set3();

		add(set1, BorderLayout.WEST);
		add(set2, BorderLayout.CENTER);
		add(set3, BorderLayout.EAST);

		submit = new JButton("Accept Input");
		submit.addActionListener(e -> makeProperty());
		add(submit, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	/**
	 * Makes panel to hold entered values for address, property type, built in and
	 * square footage.
	 */
	private void set1() {
		set1 = new JPanel();
		set1.setLayout(new GridLayout(4, 2));

		JLabel aLabel = new JLabel("Address: " + address);
		set1.add(aLabel);
		JLabel tLabel = new JLabel("Property type: " + type);
		set1.add(tLabel);
		JLabel btLabel = new JLabel("Built In: " + builtIn);
		set1.add(btLabel);
		JLabel sLabel = new JLabel("Number of Square Footage: " + sqft);
		set1.add(sLabel);
	}

	/**
	 * Makes panel to hold entered values for number of rooms, number of baths and
	 * size of yard.
	 */
	private void set2() {
		set2 = new JPanel();
		set2.setLayout(new GridLayout(4, 2));

		JLabel rLabel = new JLabel("Number of Rooms: " + rooms);
		set2.add(rLabel);
		JLabel baLabel = new JLabel("Number of Bathrooms: " + bath);
		set2.add(baLabel);
		JLabel yLabel = new JLabel("Size of Yard (in acres): " + yard);
		set2.add(yLabel);
	}

	/**
	 * Makes panel to hold entered values for security system, fireplace, garage and
	 * pool.
	 */
	private void set3() {
		set3 = new JPanel();
		set3.setLayout(new GridLayout(4, 2));

		JLabel secLabel = new JLabel("Security System: " + hasSecurity);
		set3.add(secLabel);
		JLabel firLabel = new JLabel("Fireplace: " + hasFireplace);
		set3.add(firLabel);
		JLabel garLabel = new JLabel("Garage: " + hasGarage);
		set3.add(garLabel);
		JLabel poLabel = new JLabel("Pool: " + hasPool);
		set3.add(poLabel);
	}

	/**
	 * Creates a Property object from values entered by user
	 */
	public void makeProperty() {

		if (type == "Commercial") {
			toSell = new Commercial();
		} 
		else {
			toSell = new Residential();
		}
		//Passes field values to create property
		toSell.setAddress(address);
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

		//Calculate price for the property
		Appraiser acme = new Appraiser();
		acme.calculatePropertyValue(sqft, yard, hasSecurity, hasPool, hasFireplace, hasGarage);
		toSell.setValue(acme.getPropertyValue());

		try {
			acme.addPropertyToDatabase(toSell); // Add property to archive

		}catch (IOException e1) {
			e1.printStackTrace();
		}

		DecimalFormat dollar = new DecimalFormat("0.00");

		JOptionPane.showMessageDialog(null, "Congrats! You just listed a property for sale! "
											+ "We value the property at $"
											+ dollar.format(toSell.getValue()));
		System.exit(0);
	}
}

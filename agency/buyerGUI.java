package agency;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class buyerGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	File f1 = new File("propertiesforsale.dat");
	File f2 = new File("soldproperties.dat");
	ObjectInputStream is;
	ObjectOutputStream os;

	JPanel searchSortPanel, criteriaPanel, buttonPanel, searchResultsPanel;
	JButton filterSearchButton;
	JOptionPane purchaseOrRentConfirm;
	ArrayList<Property> listOfProperties;
	ArrayList<JPanel> listOfPropertiesText;
	JList<ArrayList<JPanel>> propertyList;
	JScrollPane listScroll, boxScroll;
	JComboBox<String> typeSelect;
	JTextField roomInput, squareFeetInput, garageInput, unitsInput, bathsInput, backyardInput, verandaInput, floorInput;
	JRadioButton rentableButton, secSystemButton, parkingButton, poolButton, fireplaceButton; // there's probably a
																								// better button for
																								// residential/commercial
	boolean rentable, hasSecurity, hasParking, hasPool, hasFireplace;
	int numRooms, squareFeet, numGarage, numUnits, floorAmt;
	double numBaths, backyard, verandaSize;
	String propertyType;

	public buyerGUI() {
		super("buyerGUI");
		makeBuyerGUI();
	}

	public void makeBuyerGUI() {
		searchSortPanel = new JPanel();
		criteriaPanel = new JPanel();
		buttonPanel = new JPanel();
		searchResultsPanel = new JPanel();
		purchaseOrRentConfirm = new JOptionPane();
		listOfProperties = new ArrayList<>();
		listOfPropertiesText = new ArrayList<>();
		propertyList = new JList<>();
		listScroll = new JScrollPane(propertyList);
		boxScroll = new JScrollPane(typeSelect);
		typeSelect = new JComboBox<>();
		roomInput = new JTextField("How many rooms?: ");
		squareFeetInput = new JTextField("How many square feet?: ");
		garageInput = new JTextField("How many garages?: ");
		unitsInput = new JTextField("How many units do you want?: ");
		bathsInput = new JTextField("How many bathrooms?: ");
		backyardInput = new JTextField("How big a backyard?: ");
		verandaInput = new JTextField("How big a verdana?: ");
		floorInput = new JTextField("How many floors?: ");
		poolButton = new JRadioButton("Would you like a pool?: ");
		fireplaceButton = new JRadioButton("Would you like a fireplace?: ");
		secSystemButton = new JRadioButton("Would you like a security system?: ");
		rentableButton = new JRadioButton("Would you like a rentable property?: ");
		parkingButton = new JRadioButton("Would you like parking on location?: ");
		filterSearchButton = new JButton("Click to Refresh Results");
		rentable = hasSecurity = hasParking = hasPool = hasFireplace = false;
		numRooms = squareFeet = numGarage = numUnits = floorAmt = 0;
		numBaths = backyard = verandaSize = 0.0;

		this.setTitle("Search Properties");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(searchSortPanel, BorderLayout.WEST);
		this.add(searchResultsPanel, BorderLayout.EAST);

		searchSortPanel.setLayout(new BorderLayout());
		searchSortPanel.add(criteriaPanel, BorderLayout.NORTH);
		searchSortPanel.add(buttonPanel, BorderLayout.SOUTH);

		criteriaPanel.setLayout(new GridLayout(0, 1));
		criteriaPanel.add(typeSelect);
		criteriaPanel.add(squareFeetInput);
		criteriaPanel.add(floorInput);
		criteriaPanel.add(bathsInput);
		criteriaPanel.add(rentableButton);
		criteriaPanel.add(secSystemButton);
		criteriaPanel.add(parkingButton);
		criteriaPanel.add(garageInput);
		criteriaPanel.add(backyardInput);

		typeSelect.addItem("Apartment");
		typeSelect.addItem("Apartment Building");
		typeSelect.addItem("Bungalow");
		typeSelect.addItem("Cape Cod");
		typeSelect.addItem("Colonial");
		typeSelect.addItem("Condo");
		typeSelect.addItem("Ranch");
		typeSelect.addItem("TownHouse");
		typeSelect.addItem("Victorian");
		typeSelect.addActionListener(e -> filterSearch());

		buttonPanel.add(filterSearchButton);

		filterSearchButton.addActionListener(e -> filterList());

		searchResultsPanel.add(listScroll);
		pack();
		setVisible(true);
	}

	public void filterSearch() {
		if (typeSelect.getSelectedItem() == "Apartment Building") {
			criteriaPanel.add(unitsInput);
		} else {
			criteriaPanel.add(roomInput);
		}
		if (typeSelect.getSelectedItem() == "Apartment" || typeSelect.getSelectedItem() == "Apartment Building") {
			criteriaPanel.add(parkingButton);
		}
		if (typeSelect.getSelectedItem() == "Bungalow") {
			criteriaPanel.add(verandaInput);
		}

	}

	public void filterList() // reads input from searchPanel, filters items in List of Properties for Sale by
							// matching input, and displays them on listPane
	{
		propertyType = (String) typeSelect.getSelectedItem();
		numRooms = Integer.parseInt(roomInput.getText());
		// floorAmt = Integer.parseInt(floorInput.getText());
		// numGarage = Integer.parseInt(garageInput.getText());
		// numUnits = Integer.parseInt(unitsInput.getText());
		squareFeet = Integer.parseInt(squareFeetInput.getText());
		numBaths = Double.parseDouble(bathsInput.getText());
		backyard = Double.parseDouble(backyardInput.getText());
		// verandaSize = Double.parseDouble(verandaInput.getText());
		if (rentableButton.isSelected()) {
			rentable = true;
		}
		if (secSystemButton.isSelected()) {
			hasSecurity = true;
		}
		if (parkingButton.isSelected()) {
			hasParking = true;
		}
		if (poolButton.isSelected()) {
			hasPool = true;
		}
		if (fireplaceButton.isSelected()) {
			hasFireplace = true;
		}
		
		for (Property comp : listOfProperties) {
			if (comp.getNumRooms() == numRooms && comp.getSquareFoot() == squareFeet && comp.getNumBath() == numBaths
					&& comp.getBackyard() == backyard && comp.isHas_fireplace() == hasFireplace
					&& comp.isHas_pool() == hasPool && comp.getPropertyType() == propertyType) {


				JTextArea info = new JTextArea();
				JButton purchase = new JButton("Purchase");
				info.setText(comp.toString());
				
				JPanel p = new JPanel();
				p.add(info);
				p.add(purchase);

				listOfPropertiesText.add(p);
				//listOfPropertiesText[j].add(purchase);
				purchase.addActionListener(e -> makePurchase(comp));
			}
		}
		while (true) {
			try {
				is = new ObjectInputStream(new FileInputStream(f1));
				Property comp = (Property) is.readObject();
				listOfProperties.add(comp);
			
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		
	}

	public void makePurchase(Property prop) {
		try {

			os = new ObjectOutputStream(new FileOutputStream(f2));

			prop.setPurchased(true);
			os.writeObject(prop);

			os.close();
			JOptionPane.showMessageDialog(null, "Congradulations! You just bought a property!");
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

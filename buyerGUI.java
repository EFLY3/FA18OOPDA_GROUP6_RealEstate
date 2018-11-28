
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class buyerGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	File f1 = new File("SoldProperties.txt"); // Save property bought by user in GUI
	File f2 = new File("propList.txt"); // Listing of all properties on sale

	JPanel searchSortPanel, criteriaPanel, buttonPanel, searchResultsPanel;
	JButton filterSearchButton;
	JOptionPane purchaseOrRentConfirm;
	ArrayList<Property> listOfProperties;
	ArrayList<JPanel> listOfPropertiesText;
	JList<ArrayList<JPanel>> propertyList;
	JScrollPane listScroll, boxScroll;
	JComboBox<String> typeSelect;
	JTextField builtInput, squareFeetInput, roomInput, bathInput, backyardInput;
	JRadioButton garageButton, secSystemButton, poolButton, fireplaceButton;
	JLabel builtLabel, squareFeetLabel, roomLabel, bathLabel, backyardLabel;
	
	JButton test;
	JButton apply;

	private boolean hasGarage, hasSecurity, hasPool, hasFireplace;
	private int builtIn, squareFeet, numRooms;
	private double numBaths, backyard;
	private String propertyType;
	private Property propertySpecs;
	private Property selectedProp;
	private JList<Property> simProp;

	public buyerGUI() {
		super("buyerGUI");
	}

	public void makeBuyerGUI() {
		searchSortPanel = new JPanel();
		criteriaPanel = new JPanel();
		searchResultsPanel = new JPanel();
		purchaseOrRentConfirm = new JOptionPane();

		listOfProperties = new ArrayList<>();
		listOfPropertiesText = new ArrayList<>();

		propertyList = new JList<>();

		listScroll = new JScrollPane(propertyList);
		boxScroll = new JScrollPane(typeSelect);

		typeSelect = new JComboBox<>();

		// Label to put questions for user
		builtLabel = new JLabel("Year of construction: ");
		squareFeetLabel = new JLabel("How many square feet?: ");
		roomLabel = new JLabel("How many rooms?: ");
		bathLabel = new JLabel("How many bathrooms?: ");
		backyardLabel = new JLabel("How big a backyard?: ");

		// TextFields to store values from questions
		builtInput = new JTextField();
		squareFeetInput = new JTextField();
		roomInput = new JTextField();
		bathInput = new JTextField();
		backyardInput = new JTextField();

		// Radio buttons for boolean values
		garageButton = new JRadioButton("Would you like a garage?: ");
		secSystemButton = new JRadioButton("Would you like a security system?: ");
		poolButton = new JRadioButton("Would you like a pool?: ");
		fireplaceButton = new JRadioButton("Would you like a fireplace?: ");

		filterSearchButton = new JButton("Click to Refresh Results");

		// Set fields to default values
		hasGarage = hasSecurity = hasPool = hasFireplace = false;
		builtIn = squareFeet = numRooms = 0;
		numBaths = backyard = 0.0;

		// Create frame layout
		this.setTitle("Search Properties");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 1));
		// Panel to let the user select property features
		this.add(searchSortPanel);
		searchSortPanel.setLayout(new BorderLayout());
		searchSortPanel.add(criteriaPanel, BorderLayout.CENTER);
		criteriaPanel.setLayout(new GridLayout(0, 1));
		criteriaPanel.add(builtLabel);
		criteriaPanel.add(builtInput);
		criteriaPanel.add(squareFeetLabel);
		criteriaPanel.add(squareFeetInput);
		criteriaPanel.add(roomLabel);
		criteriaPanel.add(roomInput);
		criteriaPanel.add(bathLabel);
		criteriaPanel.add(bathInput);
		criteriaPanel.add(backyardLabel);
		criteriaPanel.add(backyardInput);
		criteriaPanel.add(garageButton);
		criteriaPanel.add(secSystemButton);
		criteriaPanel.add(poolButton);
		criteriaPanel.add(fireplaceButton);
		criteriaPanel.add(new JLabel("  "));
		criteriaPanel.add(new JLabel("Select property type:"));
		criteriaPanel.add(typeSelect);
		// Add property types to JComboBox
		typeSelect.addItem("Apartment");
		typeSelect.addItem("Bungalow");
		typeSelect.addItem("Cape Cod");
		typeSelect.addItem("Colonial");
		typeSelect.addItem("Commercial");
		typeSelect.addItem("Condo");
		typeSelect.addItem("Ranch");
		typeSelect.addItem("TownHouse");
		typeSelect.addItem("Victorian");
		
		test = new JButton("Test");
		test.addActionListener(e -> makeProperty());
		criteriaPanel.add(test);
		
		apply = new JButton("Apply");
		apply.addActionListener(e -> makeFilteredList());
		criteriaPanel.add(apply);

		// Panel to display properties on sale that match user's selected features
		this.add(searchResultsPanel);
		searchResultsPanel.setLayout(new BorderLayout());
		searchResultsPanel.add(listScroll, BorderLayout.CENTER);
		searchResultsPanel.add(filterSearchButton, BorderLayout.SOUTH);
		filterSearchButton.addActionListener(e -> filterSearch());

		pack();
		setVisible(true);
	}

	/**
	 * Retrieve input from user, change to primitive types and save in fields
	 */
	public void filterSearch() {

		builtIn = Integer.parseInt(builtInput.getText());
		squareFeet = Integer.parseInt(squareFeetInput.getText());
		numRooms = Integer.parseInt(roomInput.getText());
		numBaths = Double.parseDouble(bathInput.getText());
		backyard = Double.parseDouble(backyardInput.getText());
		propertyType = (String) typeSelect.getSelectedItem();

		if (garageButton.isSelected()) {
			hasGarage = true;
		}
		if (secSystemButton.isSelected()) {
			hasSecurity = true;
		}
		if (poolButton.isSelected()) {
			hasPool = true;
		}
		if (fireplaceButton.isSelected()) {
			hasFireplace = true;
		}
	}

	/**
	 * Make a property object using data saved in fields
	 */
	public void makeProperty() {

		propertySpecs = new Property();
		propertySpecs.setPropertyType(propertyType);
		propertySpecs.setBuiltIn(builtIn);
		propertySpecs.setSquareFoot(squareFeet);
		propertySpecs.setNumRooms(numRooms);
		propertySpecs.setNumBath(numBaths);
		propertySpecs.setBackyard(backyard);
		propertySpecs.setRentZoning(hasGarage);
		propertySpecs.setHas_secSystem(hasSecurity);
		propertySpecs.setHas_pool(hasPool);
		propertySpecs.setHas_fireplace(hasFireplace);

		// Here are all the values that are being passed
		System.out.println("address: " + propertySpecs.getAddress());
		System.out.println(propertySpecs.propWrite());
	}

	/**
	 * Return the property created using data saved in fields
	 */
	public Property getUserPropertySpecs() {
		return propertySpecs;
	}

	/**
	 * Make a property object using data saved in fields
	 */
	public void makeFilteredList() {

		DefaultListModel<Property> list = new DefaultListModel<>();
		JButton purchase = new JButton("Purchase");

		Realtor seller = new Realtor();
		listOfProperties = seller.propertyMatched();
		for (Property comp : listOfProperties) {
			list.addElement(comp);
			simProp = new JList<>(list);
		}

		simProp.setBounds(100, 100, 75, 75);
		listScroll.add(simProp);
		listScroll.add(purchase);
		purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (simProp.getSelectedIndex() != -1) {
					selectedProp = simProp.getSelectedValue();
				}
			}
		});
	}

	public void makePurchase() throws IOException {

		Realtor r = new Realtor();
		r.saveSoldProperty(selectedProp);

		JOptionPane.showMessageDialog(null, "Congrats! You just bought a property!");

		System.exit(0);
	}
}

/**
 * buyerGUI
 *
 * Accepts inputs from the user to create a property to be sold. The questions
 * appear one at a time, then generate a review sheet if the sheet is accepted
 * it prints out the property and tell you the appraised price
 * 
 * @version 2018.11.29
 * @author E.Fliegel
 * -Edited by R.Erskine and D.Pimentel 
 */
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class buyerGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	//Components to create a panel holding a list of properties
	JList<Property> list = new JList<>();
	DefaultListModel<Property> model = new DefaultListModel<>();
	JTextArea area = new JTextArea();
	JPanel panel = new JPanel();
	JSplitPane split = new JSplitPane();
	JButton buyButton = new JButton("Buy me!!");
	
	File f1 = new File("SoldProperties.txt"); // Save property bought by user in GUI
	File f2 = new File("Test.txt"); // Listing of all properties on sale

	JPanel searchSortPanel, criteriaPanel, buttonPanel, searchResultsPanel;
	JButton filterSearchButton;
	JOptionPane purchaseOrRentConfirm;
	ArrayList<Property> listOfProperties;
	JList<ArrayList<JPanel>> propertyList;
	JScrollPane listScroll, boxScroll;
	JComboBox<String> typeSelect;
	JTextField builtInput, squareFeetInput, roomInput, bathInput, backyardInput;
	JRadioButton rentableButton, secSystemButton, poolButton, fireplaceButton, garageButton;
	JLabel builtLabel, squareFeetLabel, roomLabel, bathLabel, backyardLabel;

	private boolean rentable, hasSecurity, hasPool, hasFireplace, hasGarage;
	private int builtIn, squareFeet, numRooms;
	private double numBaths, backyard;
	private String propertyType;
	private Property propertySpecs;
	private Property selectedProp;
	
	public buyerGUI() {
		super("buyerGUI");
	}
	
	/**
	 * Creates the main frame of the buyerGUI
	 */
	public void makeBuyerGUI() {
		
		//Holding panels
		searchSortPanel = new JPanel();
		criteriaPanel = new JPanel();
		searchResultsPanel = new JPanel();
		purchaseOrRentConfirm = new JOptionPane();

		listOfProperties = new ArrayList<>();
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
		rentableButton = new JRadioButton("Would you like a rentable property?: ");
		secSystemButton = new JRadioButton("Would you like a security system?: ");
		poolButton = new JRadioButton("Would you like a pool?: ");
		fireplaceButton = new JRadioButton("Would you like a fireplace?: ");
		garageButton = new JRadioButton("Would you like a garage?: ");
		
		filterSearchButton = new JButton("Find");

		// Set fields to default values
		rentable = hasSecurity = hasPool = hasFireplace = hasGarage = false;
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
			criteriaPanel.add(rentableButton);
			criteriaPanel.add(secSystemButton);
			criteriaPanel.add(poolButton);
			criteriaPanel.add(garageButton);
			criteriaPanel.add(fireplaceButton);
			criteriaPanel.add(new JLabel("  "));
			criteriaPanel.add(new JLabel("Select property type:"));
			criteriaPanel.add(typeSelect);
				// Add property types to JComboBox
				typeSelect.addItem("Apartment");
				typeSelect.addItem("Apartment Building");
				typeSelect.addItem("Bungalow");
				typeSelect.addItem("Cape Cod");
				typeSelect.addItem("Colonial");
				typeSelect.addItem("Condo");
				typeSelect.addItem("Ranch");
				typeSelect.addItem("TownHouse");
				typeSelect.addItem("Victorian");

		// Panel to display properties on sale that match user's selected features
		this.add(searchResultsPanel);
			searchResultsPanel.setLayout(new BorderLayout());
			searchResultsPanel.add(listScroll, BorderLayout.CENTER);
			searchResultsPanel.add(filterSearchButton, BorderLayout.SOUTH);
			//Find button
			filterSearchButton.addActionListener(e -> filterSearch());
		makePanelList();
		
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

		if (rentableButton.isSelected()) {
			rentable = true;
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
		if(garageButton.isSelected()) {
			hasGarage = true;
		}
		try {
			makeProperty();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Make a property object using data saved in fields
	 */
	public void makeProperty() throws IOException {

		propertySpecs = new Property();
		propertySpecs.setPropertyType(propertyType);
		propertySpecs.setBuiltIn(builtIn);
		propertySpecs.setSquareFoot(squareFeet);
		propertySpecs.setNumRooms(numRooms);
		propertySpecs.setNumBath(numBaths);
		propertySpecs.setBackyard(backyard);
		propertySpecs.setRentZoning(rentable);
		propertySpecs.setHas_secSystem(hasSecurity);
		propertySpecs.setHas_pool(hasPool);
		propertySpecs.setHas_fireplace(hasFireplace);
		propertySpecs.setGarage(hasGarage);
		getFilteredList();
	}	
	
	/**
	 * Get list of properties and let the user know if any matches were found.
	 */
	public void getFilteredList() throws IOException {
		
		Realtor seller = new Realtor();
		seller.compareProperties(propertySpecs);
		listOfProperties = seller.getSimilarProperties();

		if (listOfProperties.size() == 0) {
			JOptionPane.showMessageDialog(null, "No properties match your criteria.");
		}
		else {
			updateList();
		}
	}

	/**
	 * Make a property object using data saved in fields
	 */
	public void makePanelList() {
		
		list.setModel(model); 
		//Add listener for every element in the list to display property details
		list.getSelectionModel().addListSelectionListener(e -> {
			selectedProp = list.getSelectedValue();
			area.setText(selectedProp.toString());
		});
		
		// Add model elements to the left 
		split.setLeftComponent(new JScrollPane(list)); 	
		
		//To purchase property selected if button is pressed
		panel.add(buyButton);
		buyButton.addActionListener(e -> {
			try {
				makePurchase();
			}catch (IOException e1) {	
				e1.printStackTrace();
			}
		});
		
		panel.add(area);
		split.setRightComponent(panel); //Add to the right button and info
		
		//Add JSplitPanel (which contains all elements) to the search panel in buyer frame
		searchResultsPanel.add(split);	
	}	
		
	/**
	 * Updates panel with new list of properties
	 */
	public void updateList() {
		
		model = new DefaultListModel<>();
		
			for (Property comp : listOfProperties) {
				model.addElement(comp);
			}
			list.setModel(model);
	}	
	
	/**
	 * To buy property selected
	 */
	public void makePurchase() throws IOException {

		Realtor r = new Realtor();
		r.saveSoldProperty(selectedProp);
		
		JOptionPane.showMessageDialog(null, "Congrats! You just bought a property!");

		System.exit(0);
	}
}

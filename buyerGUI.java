import java.awt.*;
import java.io.*;
import javax.swing.*;

public class buyerGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	File f1 = new File("propertiesforsale.dat");
	File f2 = new File("soldproperties.dat");
	ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));
	ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream (f2));
	
	JPanel searchPanel, listPanel, searchCriteriaPanel, buttonPanel;
	JButton filterSearchButton;
	JOptionPane purchaseConfirm, propertyInfo;
	Property[] listOfProperties;
	JPanel[] listOfPropertiesText;
	JList<JPanel> propertyList;
	JScrollPane listScroll,boxScroll;
	JLabel typeLabel, floorLabel, roomLabel, poolLabel, fireplaceLabel, garageLabel, securityLabel;
	JComboBox<String> typeSelect;
	JTextField floorInput, roomInput;
	JRadioButton poolButton, fireplaceButton, garageButton, securityButton;
	JButton filterButton;
	JSeparator listSearchDivider, criteriaButtonDivider;
	
	boolean hasPool, hasSecurity, hasFireplace, hasGarage;
	int rooms, floors;
	
	public buyerGUI() {
		super("buyerGUI");
		makeBuyerGUI();
	}
	public void makeBuyerGUI()
	{
		searchPanel = new JPanel();
		listPanel = new JPanel();
		searchCriteriaPanel = new JPanel();
		buttonPanel = new JPanel();
		listSearchDivider = new JSeparator();
		criteriaButtonDivider = new JSeparator();
		purchaseConfirm = new JOptionPane();
		propertyInfo = new JOptionPane();
		listOfProperties = new Property[];
		listOfPropertiesText = new JPanel[];
		propertyList = new JList(listOfPropertiesText);
		listScroll= new JScrollPane(propertyList);
		boxScroll = new JScrollPane(typeSelect);
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
		filterButton = new JButton("Filter Results");
		
		hasPool = hasSecurity = hasGarage = hasFireplace = false;
		rooms = floors = 0;
		
		this.setTitle("Search Properties");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		this.add(searchPanel, BorderLayout.WEST);
		this.add(listSearchDivider, BorderLayout.CENTER);
		this.add(listPanel, BorderLayout.EAST);
		
		filterList();
		
		listSearchDivider.setOrientation(SwingConstants.VERTICAL);
		criteriaButtonDivider.setOrientation(SwingConstants.HORIZONTAL);
		
		searchPanel.setLayout(new BorderLayout());
		searchPanel.add(searchCriteriaPanel, BorderLayout.NORTH);
		searchPanel.add(criteriaButtonDivider, BorderLayout.CENTER);
		searchPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		searchCriteriaPanel.setLayout(new GridLayout(2,0));
		searchCriteriaPanel.add(typeLabel);
		searchCriteriaPanel.add(typeSelect);
		searchCriteriaPanel.add(roomLabel);
		searchCriteriaPanel.add(roomInput);
		searchCriteriaPanel.add(floorLabel);
		searchCriteriaPanel.add(floorInput);
		searchCriteriaPanel.add(securityLabel);
		searchCriteriaPanel.add(securityButton);
		searchCriteriaPanel.add(fireplaceLabel);
		searchCriteriaPanel.add(fireplaceButton);
		searchCriteriaPanel.add(garageLabel);
		searchCriteriaPanel.add(garageButton);
		searchCriteriaPanel.add(poolLabel);
		searchCriteriaPanel.add(poolButton);
		
		buttonPanel.add(filterButton);
		filterButton.addActionListener(e -> filterList());
		
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
		
		listPanel.add(listScroll);
		
		pack();
		setVisible(true);
	}
	public void filterList() //reads input from searchPanel, filters items in List of Properties for Sale by matching input, and displays them on listPane
	{
		rooms = Integer.parseInt(roomInput.getText());
		floors = Integer.parseInt(floorInput.getText());
		if(securityButton.isSelected()) {hasSecurity = true;}
		if(fireplaceButton.isSelected()) {hasFireplace = true;}
		if(garageButton.isSelected()) {hasGarage = true;}
		if(poolButton.isSelected()) {hasPool = true;}
		int j = 0;
		
		for(int i = 0; i<100; i++)
		{
			Property comp = (Property) is.readObject();
			if(comp.hasPool == hasPool && comp.floors == floors && comp.rooms == rooms && comp.hasGarage == hasGarage && comp.hasSecurity == hasSecurity && comp.hasFireplace == hasFireplace)
			{
				JTextArea info = new JTextArea();
				JButton purchase = new JButton("Purchase");
				info.setText(comp.toString());
				listOfProperties[j] = comp;
				listOfPropertiesText[j].add(info);
				listOfPropertiesText[j].add(purchase);
				purchase.addActionListener(e->makePurchase(listOfProperties[j]));
				j++;
			}
		}
		
	}
		
	public void makePurchase(Property prop)
	{
		prop.setPurchased(true);
		os.writeObject(prop);
		
		os.close();
		purchaseConfirm.showMessageDialog(null,"Congradulations! You just bought a property!");
	} 
		
}





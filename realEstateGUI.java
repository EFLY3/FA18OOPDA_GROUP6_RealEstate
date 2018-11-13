
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class realEstateGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	File f1 = new File("propertiesforsale.dat");
	File f2 = new File("soldproperties.dat");

	JOptionPane buyerOrSellerMessage, propertyInfo, purchaseConfirm, listConfirm;
	JPanel searchPanel;
	JLabel typeLabel = new JLabel("Property Type: ");
	JLabel floorLabel = new JLabel("Number of Floors: ");
	JLabel roomLabel = new JLabel("Number of Rooms: ");
	JLabel poolLabel = new JLabel("Pool: ");
	JLabel fireplaceLabel = new JLabel("Fireplace: ");
	JLabel garageLabel = new JLabel("Garage: ");
	JLabel securityLabel = new JLabel("Security System: ");
	JComboBox typeSelect = new JComboBox();
	JTextField floorInput, roomInput;
	JRadioButton poolButton, fireplaceButton, garageButton, securityButton;
	JScrollPane scroll;
	JScrollBar scrollBar;
	JList propertyList;
	Property[] listOfProperties;
	JTextArea[] listOfPropertiesText;

	public realEstateGUI()
	{
		super();
	}

	public void makeBuyerGUI() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		this.setLayout(new BorderLayout());
		this.add(searchPanel, BorderLayout.WEST);
		this.add(scroll, BorderLayout.EAST);

		typeSelect.addActionListener(e -> filterList());
		floorInput.addActionListener(e -> filterList());
		roomInput.addActionListener(e -> filterList());
		poolButton.addActionListener(e -> filterList());
		garageButton.addActionListener(e -> filterList());
		fireplaceButton.addActionListener(e -> filterList());
		securityButton.addActionListener(e -> filterList());

		searchPanel.setLayout(new GridLayout(0,2));
		searchPanel.add(typeLabel);
		searchPanel.add(typeSelect);
		searchPanel.add(floorLabel);
		searchPanel.add(floorInput);
		searchPanel.add(roomLabel);
		searchPanel.add(roomInput);
		searchPanel.add(poolLabel);
		searchPanel.add(poolButton);
		searchPanel.add(garageLabel);
		searchPanel.add(garageButton);
		searchPanel.add(fireplaceLabel);
		searchPanel.add(fireplaceButton);
		searchPanel.add(securityLabel);
		searchPanel.add(securityButton);

		scroll.add(propertyList);
		scroll.add(scrollBar);

		ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));
		for(int i = 0; i<100; i++)
		{
			JButton purchase = new JButton("Purchase");
			purchase.addActionListener(e->purchaseProperty());
			listOfProperties[i] = (Property) is.readObject();
			listOfPropertiesText[i].setText(is.readObject().toString());
			listOfPropertiesText[i].add(purchase);
			propertyList.add(listOfPropertiesText[i]);
		}
		is.close();

		pack();
		setVisible(true);
	}

	private void makeSellerGUI()
	{
		this.setLayout(new GridLayout(0,2));

		typeSelect.addActionListener(e->makeProperty());
		floorInput.addActionListener(e -> makeProperty());
		roomInput.addActionListener(e -> makeProperty());
		poolButton.addActionListener(e -> makeProperty());
		garageButton.addActionListener(e -> makeProperty());
		fireplaceButton.addActionListener(e -> makeProperty());
		securityButton.addActionListener(e -> makeProperty());

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

	private void filterList()
	{
		//filter the list of properties on the gui based on search items
	}

	private void purchaseProperty()
	{
		//purchase the selected property by interacting with the listOfProperties and listOfPropertiesText arrays and the purchase method in the property, and write property to the listofsoldproperties
	}
	private void makeProperty()
	{
		//create a property using the input from the user, and puts it in the propertiesforsale list
	}
}

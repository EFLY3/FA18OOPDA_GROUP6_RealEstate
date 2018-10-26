import java.awt.GridLayout;
import java.io.*;
import javax.swing.*;

public class searchPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean hasPool = false, hasSecurity = false, hasFireplace = false, hasGarage = false;
	int rooms = 0, floors = 0;
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
	public searchPanel(listPane list)
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
	
	public void makeComparison() // determines attributes of properties based on input
	{
		floors = Integer.parseInt(floorInput.getText());
		rooms = Integer.parseInt(roomInput.getText());
		if(poolButton.isSelected())
		{
			hasPool = true;
		}
		if(securityButton.isSelected());
		{
			hasSecurity = true;
		}
		if(garageButton.isSelected())
		{
			hasGarage = true;
		}
		if(fireplaceButton.isSelected())
		{
			hasFireplace = true;
		}
		
	}
}

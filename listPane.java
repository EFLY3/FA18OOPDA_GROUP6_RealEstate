import java.io.*;
import javax.swing.*;

public class listPane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File f1 = new File("propertiesforsale.dat");
	File f2 = new File("soldproperties.dat");
	//ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream (f1));
	//ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));
	JOptionPane propertyInfo;
	JScrollPane scroll;
	JScrollBar scrollBar;
	JList<Property> propertyList;
	Property[] listOfProperties;
	JTextArea[] listOfPropertiesText;
	searchPanel searchP;
	public listPane(searchPanel search)
	{
		this.add(scroll);
		filterResults();
		scroll.add(propertyList);
		scroll.add(scrollBar);
		searchP = search;
	

	}
	public void filterResults() //reads input from searchPanel, filters items in List of Properties for Sale by matching input, and displays them on listPane
	{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));
		for(int i = 0; i<100; i++)
		{
			JButton purchase = new JButton("Purchase");
			purchase.addActionListener(e->makePurchase());
			Property comp = (Property) is.readObject();
			if(searchP.hasPool == comp.hasPool && searchP.floors == comp.floors && searchP.rooms == comp.rooms && searchP.hasGarage == comp.hasGarage && searchP.hasSecurity == comp.hasSecurity && searchP.hasFireplace == comp.hasFireplace)
			{
			listOfProperties[i] = comp;
			listOfPropertiesText[i].setText(comp.toString());
			listOfPropertiesText[i].add(purchase);
			propertyList.add(listOfPropertiesText[i]);
			}
		}
		is.close();
	}
	public void makePurchase()
	{
		//will register the object as purchased, remove it from the list of properties for sale, add it to sold properties, and display message
	}
	
}

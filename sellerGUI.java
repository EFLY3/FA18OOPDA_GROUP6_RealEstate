
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class sellerGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<String> typeSelect;
	
	JPanel set1, set2, set3;
	
	boolean hasPool, hasSecurity, hasFireplace, hasGarage;
	int rooms, sqft, floors, builtIn;
	double bath, yard;
	String address, type;
	JButton submit;
	Property toSell;

	public sellerGUI() {
		super("sellerGUI");
		
		hasPool = hasSecurity = hasFireplace = hasGarage = false;
		
		int r = 0;
		
		String[] possibleValues = { "Colonial", "Ranch", "Bungalow", "Victorian", "BiLevel", "Mobile",
									"Commercial", };
		
		
		address = JOptionPane.showInputDialog("What is the Address?");
		type = (String) JOptionPane.showInputDialog(null,
				"What type of property is it?", "Choose One",
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);
		builtIn = Integer.parseInt(JOptionPane.showInputDialog("When was the property built?"));
		sqft = Integer.parseInt(JOptionPane.showInputDialog("How many square feet is the property?"));
		rooms = Integer.parseInt(JOptionPane.showInputDialog("How many bedrooms are in the property?"));
		bath = Double.parseDouble(JOptionPane.showInputDialog("How many bathrooms are in the property?"));
		floors = Integer.parseInt(JOptionPane.showInputDialog("How many floors are in the property?"));
		yard = Double.parseDouble(JOptionPane.showInputDialog("How much acreage does the property have?"));
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a pool?", "Choose One", JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasPool = true;
		}
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a security system?", "Choose One" , JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasSecurity = true;
		}
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a fireplace?", "Choose One" , JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasFireplace = true;
		}
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a garage?", "Choose One" , JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasGarage = true;
		}
		
		makeSellerGUI();
	}

	public void makeSellerGUI() {
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Review your Input");
		setLayout(new BorderLayout());
		
		set1();
		set2();
		set3();
		
		add(set1,BorderLayout.WEST);
		add(set2, BorderLayout.CENTER);
		add(set3, BorderLayout.EAST);
		
		submit = new JButton("Accept Input");
		submit.addActionListener(e -> makeProperty());
		add(submit, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	private void set1()
	{
		set1 = new JPanel();
		set1.setLayout(new GridLayout(4,2));
		
		JLabel aLabel = new JLabel("Address: " + address);
		set1.add(aLabel);
		JLabel tLabel = new JLabel("Property type: " + type);
		set1.add(tLabel);
		JLabel btLabel = new JLabel("Built In: " + builtIn);
		set1.add(btLabel);
		JLabel sLabel = new JLabel("Number of Square Footage: " + sqft);
		set1.add(sLabel);
		
	}
	
	private void set2()
	{
		set2 = new JPanel();
		set2.setLayout(new GridLayout(4,2));
		
		JLabel rLabel = new JLabel("Number of Rooms: " + rooms);
		set2.add(rLabel);
		JLabel baLabel = new JLabel("Number of Bathrooms: " + bath);
		set2.add(baLabel);
		JLabel flLabel = new JLabel("Number of Floors: " + floors);
		set2.add(flLabel);
		JLabel yLabel = new JLabel("Size of Yard (in acres): " + yard);
		set2.add(yLabel);
		
	}
	
	private void set3()
	{
		set3 = new JPanel();
		set3.setLayout(new GridLayout(4,2));
		
		JLabel secLabel = new JLabel("Security System: " + hasSecurity);
		set3.add(secLabel);
		JLabel firLabel = new JLabel("Fireplace: " + hasFireplace);
		set3.add(firLabel);
		JLabel garLabel = new JLabel("Garage: " + hasGarage);
		set3.add(garLabel);
		JLabel poLabel = new JLabel("Pool: " + hasPool);
		set3.add(poLabel);
		
	}
	
	
public void makeProperty()
{
			
			
			if (type == "Commercial")
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
			toSell.setFloors(floors);
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

			// Pass property to Appraiser to save
			Appraiser a = new Appraiser();
			try {
				a.addPropertyToDatabase(toSell);
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			DecimalFormat dollar = new DecimalFormat("0.00");
			
			JOptionPane.showMessageDialog(null,
					"Congrats! You just listed a property for sale! We value the property at " + dollar.format(toSell.getValue()));
			
			System.exit(0);
		
	}}


import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class sellerGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<String> typeSelect;
	
	JPanel set1, set2, set3;
	
	boolean hasPool, hasSecurity, hasFireplace, hasGarage;
	int rooms, sqft, builtIn;
	double bath, yard;
	String address, type;
	JButton submit;
	Property toSell;

	public sellerGUI() {
		super("sellerGUI");
		
		hasPool = hasSecurity = hasFireplace = hasGarage = false;
		
		int r = 0;
		
		String[] possibleValues = { "Colonial", "Ranch", "Bungalow", "Victorian", "BiLevel", "Mobile",
									"Commercial", };
		
		
		address = JOptionPane.showInputDialog("What is the Address?");
		type = (String) JOptionPane.showInputDialog(null,
				"What type of property is it?", "Choose One",
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);
		builtIn = Integer.parseInt(JOptionPane.showInputDialog("When was the property built?"));
		sqft = Integer.parseInt(JOptionPane.showInputDialog("How many square feet is the property?"));
		rooms = Integer.parseInt(JOptionPane.showInputDialog("How many bedrooms are in the property?"));
		bath = Double.parseDouble(JOptionPane.showInputDialog("How many bathrooms are in the property?"));
		yard = Double.parseDouble(JOptionPane.showInputDialog("How much acreage does the property have?"));
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a pool?", "Choose One", JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasPool = true;
		}
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a security system?", "Choose One" , JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasSecurity = true;
		}
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a fireplace?", "Choose One" , JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasFireplace = true;
		}
		
		r = JOptionPane.showConfirmDialog(null,
				"Does the property have a garage?", "Choose One" , JOptionPane.YES_NO_OPTION);
		if (r == 0)
		{
			hasGarage = true;
		}
		
		makeSellerGUI();
	}

	public void makeSellerGUI() {
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Review your Input");
		setLayout(new BorderLayout());
		
		set1();
		set2();
		set3();
		
		add(set1,BorderLayout.WEST);
		add(set2, BorderLayout.CENTER);
		add(set3, BorderLayout.EAST);
		
		submit = new JButton("Accept Input");
		submit.addActionListener(e -> makeProperty());
		add(submit, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	private void set1()
	{
		set1 = new JPanel();
		set1.setLayout(new GridLayout(4,2));
		
		JLabel aLabel = new JLabel("Address: " + address);
		set1.add(aLabel);
		JLabel tLabel = new JLabel("Property type: " + type);
		set1.add(tLabel);
		JLabel btLabel = new JLabel("Built In: " + builtIn);
		set1.add(btLabel);
		JLabel sLabel = new JLabel("Number of Square Footage: " + sqft);
		set1.add(sLabel);
		
	}
	
	private void set2()
	{
		set2 = new JPanel();
		set2.setLayout(new GridLayout(4,2));
		
		JLabel rLabel = new JLabel("Number of Rooms: " + rooms);
		set2.add(rLabel);
		JLabel baLabel = new JLabel("Number of Bathrooms: " + bath);
		set2.add(baLabel);
		JLabel yLabel = new JLabel("Size of Yard (in acres): " + yard);
		set2.add(yLabel);
		
	}
	
	private void set3()
	{
		set3 = new JPanel();
		set3.setLayout(new GridLayout(4,2));
		
		JLabel secLabel = new JLabel("Security System: " + hasSecurity);
		set3.add(secLabel);
		JLabel firLabel = new JLabel("Fireplace: " + hasFireplace);
		set3.add(firLabel);
		JLabel garLabel = new JLabel("Garage: " + hasGarage);
		set3.add(garLabel);
		JLabel poLabel = new JLabel("Pool: " + hasPool);
		set3.add(poLabel);
		
	}
	
	
public void makeProperty()
{
			
			
			if (type == "Commercial")
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
			
			DecimalFormat dollar = new DecimalFormat("0.00");
			
			JOptionPane.showMessageDialog(null,
					"Congrats! You just listed a property for sale! We value the property at " + dollar.format(toSell.getValue()));
			
			System.exit(0);
		
	}}


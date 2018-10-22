package Acme_Realty;

/**
 *	abstract class Property
 *		String address
 *		int built
 *		int squareFoot
 *		int numRooms
 *		double numBath
 *		boolean rentZoning
 *		boolean has_secSystem
 *
 *	The parent class of all properties listed in Acme Realty.
 *	created 10/16/18 - R. Erskine
 */
public abstract class Property implements Rentable
{

	protected String address;
	protected int builtIn;
	protected int squareFoot;
	protected int numRooms;
	protected double numBath;
	protected boolean rentZoning;
	protected boolean has_secSystem;
	
	//default constructor
	public Property()
	{
		address = "";
		builtIn = 0;
		squareFoot = 0;
		numRooms = 0;
		numBath = 0.0;
		rentZoning = true;
		has_secSystem = true;
	}

	//Setters and Getters
	public int getSquareFoot() {
		return squareFoot;
	}

	public void setSquareFoot(int squareFoot) {
		this.squareFoot = squareFoot;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
	
	public double getNumBath() {
		return numBath;
	}

	public void setNumBath(double numBath) {
		this.numBath = numBath;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBuiltIn() {
		return builtIn;
	}

	public void setBuiltIn(int builtIn) {
		this.builtIn = builtIn;
	}

	public boolean isRentZoning() {
		return rentZoning;
	}

	public void setRentZoning(boolean rentZoning) {
		this.rentZoning = rentZoning;
	}

	public boolean isHas_secSystem() {
		return has_secSystem;
	}

	public void setHas_secSystem(boolean has_secSystem) {
		this.has_secSystem = has_secSystem;
	}

	//rentable defined - if the zone allows renting and the property is atleast 1000 sqft 
	// then the property is rentable
	public boolean rentable()
	{
		if(rentZoning == true && this.squareFoot>1000)
		{
			return true;
		}
		
		return false;
	}
	//basic toString
	@Override
	public String toString() 
	{
		return "" + address + "\n" + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath;
	}

}

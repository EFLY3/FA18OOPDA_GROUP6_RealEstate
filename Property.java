
/**
 *	abstract class Property
 *		String address
 *		String propertyType
 *		int built
 *		int squareFoot
 *		int numRooms
 *		double numBath
 *		double backyard
 *		boolean rentZoning
 *		boolean has_secSystem
 *		boolean has_pool
 *		boolean has_fireplace
 *		boolean has_garage
 *		double value
 *
 *	The parent class of all properties listed in Acme Realty.
 *	created 10/16/18 - R. Erskine
 *	edited 11/15/18 - R.Erskine
 */
public class Property implements Rentable
{

	//property Strings
	protected String address;
	protected String propertyType;
	
	//property number stats
	protected int builtIn;
	protected int squareFoot;
	protected int numRooms;
	protected double numBath;
	protected double backyard;
	
	//property features
	protected boolean rentZoning;
	protected boolean has_secSystem;
	protected boolean has_pool;
	protected boolean has_fireplace;
	protected boolean has_garage;
	
	//property value
	protected double value;
	
	//default constructor
	public Property()
	{
		address = "";
		propertyType = "";
		
		builtIn = 0;
		squareFoot = 0;
		numRooms = 0;
		numBath = 0.0;
		backyard = 0.0;
		
		rentZoning = false;
		has_secSystem = false;
		has_pool = false;
		has_fireplace = false;
		has_garage = false;
		
		value = 0.0;
	}
	
	//all input constructor
	public Property(String add, String type, int built, int foot, int room, double bath, double yard,
					boolean zone, boolean sec, boolean pool, boolean fire, boolean gara)
	{
		address = add;
		propertyType = type;
		
		builtIn = built;
		squareFoot = foot;
		numRooms = room;
		numBath = bath;
		backyard = yard;
		
		rentZoning = zone;
		has_secSystem = sec;
		has_pool = pool;
		has_fireplace = fire;
		has_garage = gara;
		
		value = 0.0;
	}

	public boolean getGarage() {
		return has_garage;
	}

	public void setGarage(boolean has_garage) {
		this.has_garage = has_garage;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public double getBackyard() {
		return backyard;
	}

	public void setBackyard(double backyard) {
		this.backyard = backyard;
	}

	public boolean isHas_pool() {
		return has_pool;
	}

	public void setHas_pool(boolean has_pool) {
		this.has_pool = has_pool;
	}

	public boolean isHas_fireplace() {
		return has_fireplace;
	}

	public void setHas_fireplace(boolean has_fireplace) {
		this.has_fireplace = has_fireplace;
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
		return "" + address + "\n" + propertyType + "\n" + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n" + backyard + "\n" + rentZoning + "\n" + has_secSystem + "\n" 
				+ has_pool + "\n" + has_fireplace + "\n" + value + "\n";
	}
	
	public String propWrite()
	{
		return "" + address + " " + propertyType + " " + builtIn + " " + squareFoot + " "
				+ numRooms + " " + numBath + " " + backyard + " " + rentZoning + " " + has_secSystem + " " 
				+ has_pool + " " + has_fireplace + " " + value + " ";
	}

}

package Acme_Realty;

/**
 *	class Condo
 *		Condo is a Residential subclass. They are single apartment-like units but they are
 *		owned, not strictly rented. No yards. No garages. Onsite Parking. 
 *		
 * created 10/17/18 - R.Erskine
 */
public class Condo extends Residential
{
	private boolean onsiteParking;
	
	public Condo()
	{
		super();
		onsiteParking = true;
	}

	public boolean isOnsiteParking() {
		return onsiteParking;
	}

	public void setOnsiteParking(boolean onsiteParking) {
		this.onsiteParking = onsiteParking;
	}
	
	@Override
	public String toString() {
		return "Condo \n" + PROP_TYPE + "\n" + address + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n" + onsiteParking + "\n";
	}

}

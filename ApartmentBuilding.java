package Acme_Realty;
import java.util.ArrayList;

/**
 *	class ApartmentBuilding
 *		ApartmentBuilding is a MultiStory subclass. ApartmentBuilding contains an ArrayList
 *		containing Apartments.
 *		
 * created 10/17/18 - R.Erskine
 */
public class ApartmentBuilding extends MultiStory
{
	private ArrayList<Apartment> units;
	
	public ApartmentBuilding()
	{
		units = new ArrayList<>();
	}
	
	//add a new Apartment room to ApartmentBuilding
	public void newUnit()
	{
		units.add(new Apartment());
	}
	
	@Override
	public String toString() {
		return "Apartment Building \n" + address + "\n" + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n";
	}

}

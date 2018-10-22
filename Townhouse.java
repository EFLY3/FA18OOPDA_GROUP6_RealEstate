package Acme_Realty;

/**
 *	class Townhouse
 *		Townhouse is a MultiStory subclass. No yard, built right next to each other.
 *		
 * created 10/17/18 - R.Erskine
 */
public class Townhouse extends MultiStory
{

	public Townhouse()
	{
		super();
	}
	
	@Override
	public String toString() {
		return "Townhouse \n" + PROP_TYPE + "\n" + address + "\n" + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n";
	}
}

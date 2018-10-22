package Acme_Realty;

/**
 *	class Ranch
 *		Ranch is a SingleStory subclass. It's attached garage is what makes it
 *		unique from Bungalow subclass.
 *		
 * created 10/17/18 - R.Erskine
 */
public class Ranch extends SingleStory
{
	private int numGarage;
	
	public Ranch()
	{
		super();
		numGarage = 0;
	}

	public int getNumGarage() {
		return numGarage;
	}

	public void setNumGarage(int numGarage) {
		this.numGarage = numGarage;
	}

	@Override
	public String toString() {
		return "Ranch \n" + PROP_TYPE + "\n" + address + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n" + numGarage + "\n";
	}
	

}

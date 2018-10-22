package Acme_Realty;

/**
 *	class Bungalow
 *		Bungalow is a SingleStory subclass. The veranda is the unique feature of the
 *		Bungalow and will be measured by (int verandaSize)feet from the house.
 *		
 * created 10/17/18 - R.Erskine
 */
public class Bungalow extends SingleStory
{

	private int verandaSize;
	
	public Bungalow()
	{
		super();
		verandaSize = 0;
	}

	public int getVerandaSize() {
		return verandaSize;
	}

	public void setVerandaSize(int verandaSize) {
		this.verandaSize = verandaSize;
	}
	
	@Override
	public String toString() {
		return "Bungalow \n" + PROP_TYPE + "\n" + address + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n" + verandaSize + "\n";
	}
}

package Acme_Realty;

/**
 *	class Victorian
 *		Victorian is a MultiStory subclass. Colonial, Cape Cod, Victorian are all very closely
 *		defined to each other, but we could make each one a different set floor count on
 *		construction. 
 *		
 * created 10/17/18 - R.Erskine
 */
public class Victorian extends MultiStory
{
	private double backyard;
	private int numGarage; 
	
	public Victorian()
	{
		super();
		backyard = 0.0;
		numGarage = 0;
	}

	public double getBackyard() {
		return backyard;
	}

	public void setBackyard(double backyard) {
		this.backyard = backyard;
	}

	public int getNumGarage() {
		return numGarage;
	}

	public void setNumGarage(int numGarage) {
		this.numGarage = numGarage;
	}

	@Override
	public String toString() {
		return "Victorian \n" + PROP_TYPE + "\n" + address + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n" + numGarage + "\n" + backyard + "\n";
	}
}
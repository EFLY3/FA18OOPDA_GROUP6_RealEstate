package agency;

import java.util.ArrayList;

   /** The appraiser compares the property with three 
	 * or four similar homes that have sold in the area,
	 * often called comparables, or comps. 
	 * 
	 *  The analysis considers specific components, such as: 
		 * -lot size, 
		 * -square footage of finished and unfinished space, 
		 * -style 
		 * -age of house 
		 * -statements regarding serious structural problems, 
		 *  such as wet basements and cracked foundations
		 * -notes about the surrounding area, such as new or 
		 *  established development, rural acreage, and so on.
		 * -other features such as garages and fireplaces.
	 *
	 * A common misunderstanding is that the appraisal amount is 
	 * only for the house itself. In fact, the figure appraises the 
	 * total value of the home and any other permanent structures, 
	 * along with the land that the house is built on. 
	 */
public class Appraiser { 
	
	private Agency propertySpecs; // Specifications of the seller's property 
	private double averagePrice; // Average price of similar properties
	private ArrayList<HousingList> toBeSold; // List of houses for sale
	private ArrayList<ArchivedProperties> listing; // List of sold properties
	private ArrayList<ArchivedProperties> comparables; // List of similar sold properties
	
	/** 
	 * constructor to receive data only from the Agency
	 */
	public Appraiser(Agency propertySpecs) 
	{
		this.propertySpecs = propertySpecs;
		averagePrice = 0;
		toBeSold = new ArrayList<>();
		comparable = new ArrayList<>();
	}

	/** 
	 * Matches seller's info with sold properties from ArchivedProperties
	 */
	public void compareProperties() 
	{
		for(ArchivedProperties a: listing) {
			/**'if' statements to sort similar properties
			 *  save in similar properties 
			 *  in collection comparables
			 *
			 *
			 */ 
				comparables.add(a);
			
			/**else 
	    	 *	display: No properties found or exception could be added 	
	    	 */
		}
	}

	/** 
	 * Calculate price of seller's property
	 */ 
	public void calculatePropertyPrice() 
	{	
		double total = 0;
		for(ArchivedProperties a : comparables) 
		{
			total += a.getPrice(); // method must be in ArchivedProperties
		}
		
		averagePrice = total / comparables.size();
		
		/** add or reduce price according to state of the property
		 *  
		 *  We could have a separate class that handles the deduction
		 *  or addition of property value:
		 *  		 e.g. +$2,000 for newly installed bathtub
		 *                -$500 for broken doors  
		 */
		averagePrice += // renovation, land, etc.
		averagePrice -= // structural problems, house age, etc.			
	}

	/** 
	 * Return calculated price of property 
	 */ 
	public double getPropertyPrice() 
	{
		return averagePrice;
	}
	
	/** 
	 * Set obtained average price to new property
	 */  
	public void setPropertyPrice(double averagePrice) 
	{
		this.averagePrice = averagePrice;
	}
	
	/** 
	 * Add property to Housing List Database
	 */  
	public void addPropertyToDatabase(Agency propertyAppraised) 
	{
		toBeSold.add(propertyAppraised);
	}
}

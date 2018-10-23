package agency;

import java.util.ArrayList;

/**
 * The Realtor is in charge of presenting the options that match the buyers' criteria, 
 * and saves any sold properties in archivedProperties.
 */
public class Realtor {

	private Agency propertySpecs; // Specifications of the seller's property 
	private ArrayList<HousingList> toBeSold; // List of houses for sale
	private ArrayList<HousingList> similarProperties; // Properties matching the specifications
	
	/** 
	 * constructor to receive data only from the Agency
	 */
	public Realtor(Agency propertySpecs) 
	{
		this.propertySpecs = propertySpecs;
	}
	
	/**
	 *  Compare properties for sale in HouseListing to the buyer's specifications
	 */
	public void compareProperties() 
	{
		for(HousingList h: toBeSold) 
		{
			/**'if' statements to sort and save similar properties from the 
			 *  HouseListing that match search criteria in propertySpecs 
			 *  
			 *  save in collection similarProperties
			 */ similarProperties.add(h);
			
			/**else 
	    		 display: No properties found matching your criteria 
			 *   or exception could be added	
	    	 */
		}
	}
	
	/**
	 *  Return the properties of the HousingList that match the search
	 */
	public HousingList propertyMatches() 
	{
		for(HousingList h: similarProperties) {
			return h;
			//Display all info, especially price
		}
	}
	
	/**
	 *  Save sold property in ArchivedProperties
	 */
	public void saveSoldProperty(HousingList sold) {
		
		/**
		 *  Data could be stored in an Excel workbook,
		 *  exceptions could be added here to handle problems
		 *  with the file creation
		 */
	}
}

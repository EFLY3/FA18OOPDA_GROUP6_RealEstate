
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Realtor is in charge of presenting the options that match the buyers'
 * criteria, and saves any sold properties in archivedOfPropertiesSold.
 */
public class Realtor {

	private Property propertySpecs; // Specifications of the seller's property
	private ArrayList<Property> similarProperties; // Properties matching the specifications
	private ArrayList<Property> listing; // All the properties on sale
	private File f1 = new File("ArchiveOfPropertiesSold.txt");

	/**
	 * constructor to receive the specifications of the property that user wants to buy.
	 */
	public Realtor() {//Property propertySpecs) {
		//this.propertySpecs = propertySpecs;
		similarProperties = new ArrayList<>();
		listing = new ArrayList<>();
	}

	/**
	 * Retrieves properties saved in text file and puts them in an ArrayList to be sorted
	 * later in compareProperties() 
	 * @throws IOException 
	 */
	public ArrayList<Property> getListing() throws IOException{

		FileHandler propList = new FileHandler();
		propList.retrievePropertyObject(new File ("propList.txt"));
		listing = propList.returnProperties();

		return listing;
	}

	/**
	 * Compare properties for sale in HouseListing to the buyer's specifications
	 */
	public void compareProperties(Property specs) {
		/**
		 * Sorting of files could be made from this class
		 * 
		 * 'if' statements to sort and save similar properties from the HouseListing
		 * that match search criteria in propertySpecs and save in collection similarProperties
		 *
		 * Maybe display: No properties found matching your criteria or exception could
		 * be added
		 */
		for (Property p : listing) {

			buyerGUI b = new buyerGUI();
			propertySpecs = b.getUserPropertySpecs();
			if (propertySpecs.getPropertyType().equals(p.getPropertyType())
					&& propertySpecs.getBuiltIn() == p.getBuiltIn()
					&& propertySpecs.getSquareFoot() == p.getSquareFoot()
					&& propertySpecs.getNumRooms() == p.getNumRooms()
					&& propertySpecs.getNumBath() == p.getNumBath()
					&& propertySpecs.getBackyard() <= p.getBackyard() 
					&& propertySpecs.isRentZoning() == p.isRentZoning()
					&& propertySpecs.isHas_secSystem() == p.isHas_secSystem()
					&& propertySpecs.isHas_pool() == p.isHas_pool()
					&& propertySpecs.isHas_fireplace() == p.isHas_fireplace())

				similarProperties.add(p); // Add matching property to an ArrayList
		}
	}

	/**
	 * Return the properties that match the search
	 */
	public ArrayList<Property> propertyMatched() {
		return similarProperties;
	}


	/**
	 * Save sold property in ArchivedProperties
	 */
	public void saveSoldProperty(Property prop) throws IOException {

		/**
		 * Data could be stored in an Excel workbook, exceptions could be added here to
		 * handle problems with the file creation
		 */
		try {
			FileHandler saveProp = new FileHandler();
			saveProp.writeFile(prop, f1);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}

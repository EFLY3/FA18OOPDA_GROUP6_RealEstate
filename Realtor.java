import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Realtor class findings properties in the database that match the user's
 * search criteria and removes from the database the property bought.
 * 
 * @version 2018.11.29
 * @author D.Pimentel
 */
public class Realtor {
	
	private ArrayList<Property> similarProperties; // Properties matching the specifications
	private ArrayList<Property> listing; // All the properties on sale
	private File f1 = new File("SoldProperties.txt");
	private File f2 = new File("PropertiesForSale.txt");

	/**
	 * constructor to receive the specifications of the property that user wants to buy.
	 */
	public Realtor() {
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
		propList.retrievePropertyObject(f2);
		listing = propList.returnProperties();

		return listing;
	}

	/**
	 * Compare properties for sale in HouseListing to the buyer's specifications
	 * @throws IOException 
	 */
	public void compareProperties(Property specs) throws IOException {
		
		getListing(); // Create arrayList to compare
		
		
		for (Property p : listing) {	
			if (specs.getPropertyType().equals(p.getPropertyType())
					&& specs.getBuiltIn() <= p.getBuiltIn()
					&& specs.getSquareFoot() >= p.getSquareFoot()
					&& specs.getNumRooms() == p.getNumRooms()
					&& specs.getNumBath() == p.getNumBath()
					&& specs.getBackyard() >= p.getBackyard() 
					&& specs.isRentZoning() == p.isRentZoning()
					&& specs.isHas_secSystem() == p.isHas_secSystem()
					&& specs.isHas_pool() == p.isHas_pool()
					&& specs.isHas_fireplace() == p.isHas_fireplace())

				similarProperties.add(p); // Add matching property to an ArrayList
		}
	}

	/**
	 * Return the properties that match the search
	 */
	public ArrayList<Property> getSimilarProperties() {
		return similarProperties;
	}


	/**
	 * Save sold property in ArchivedProperties
	 */
	public void saveSoldProperty(Property prop) throws IOException {

		try {
			FileHandler saveProp = new FileHandler();
			saveProp.writeFile(prop, f1);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		removeSoldProperty(prop);
	}
	
	/**
	 * Property sold that needs to be removed from the properties on sale
	 * @param prop The property selected
	 * @throws IOException
	 */
	public void removeSoldProperty(Property prop) throws IOException
	{
		String deleteProp = prop.propWrite();
		String textInFile; 
		
		 File inputFile = new File("propList.txt");
	     File tempFile = new File("ItWorks.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        while((textInFile = reader.readLine()) != null) {
	            if(null!=textInFile && !textInFile.equalsIgnoreCase(prop.propWrite())){
	                writer.write(textInFile + System.getProperty("line.separator"));
	            }
	        }
	        writer.close(); 
	        reader.close(); 
	        boolean successful = tempFile.renameTo(inputFile);
	        System.out.println(successful);
	}
}

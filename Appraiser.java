import java.io.File;
import java.io.IOException;

/** The Appraiser class will assign a value to a home based on it's internal analyzer.
 *  The analysis considers specific property features.
 *  
 * @version 2018.11.29
 * @author D.Pimentel
 * edited by R.Erskine 11/15/18
 * edited by R.Erskine 11/28/18
 */
public class Appraiser { 
	
	//the built in prices the Appraiser uses to calculate the cost of a house
	private double pricePerSQFT;
	private double pricePerAcre;
	private double priceSecSys;
	private double pricePool;
	private double priceFire;
	private double priceGarage;
	
	//the house costs
	private double propertyValue;
	
	private File f1 = new File("PropertiesForSale.txt");
	
	/** 
	 * Default constructor: this is the ACME appraiser, with no custom pricing
	 */
	public Appraiser() 
	{
		pricePerSQFT = 150.00;
		pricePerAcre = 10000;
		priceSecSys = 15000;
		pricePool = 20000;
		priceFire = 7000;
		priceGarage = 5000;	
		propertyValue = 0.0;
	}

	/** 
	 * Calculate price of seller's property
	 */ 
	public void calculatePropertyValue(int sqft, double acre, boolean sec, boolean pool, 
										boolean fire, boolean gara) {	
		double total = 0.0;
		
		total += sqft * pricePerSQFT;
		total += acre * pricePerAcre;
		
		if(sec == true){
			total += priceSecSys;
		}
		
		if(pool == true){
			total += pricePool;
		}
		
		if(fire == true){
			total += priceFire;
		}
		
		if(gara == true){
			total += priceGarage;
		}
		
		propertyValue = total;
	}

	/** 
	 * Return calculated price of property 
	 */ 
	public double getPropertyValue() {
		return propertyValue;
	}
		
	/**
	 * Add property to Housing List Database
	 * @throws IOException 
	 */
	public void addPropertyToDatabase(Property prop) throws IOException {

			FileHandler file = new FileHandler();
			file.writeFile(prop, f1);
	}
}

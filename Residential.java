/**
 *	Residential
 *	subclass of Property
 *	contains the classification Residential designator
 *
 *	@version 2018.11.20
 *	@author R.Erskine 
 */
public class Residential extends Property
{
	final private String CLASSIFICATION = "Residential";
	
	public Residential(){
		super();
	}
	
	public String prop_write(){
			return ""+ CLASSIFICATION + " " + address + " " + propertyType + " " + builtIn + " " + squareFoot + " "
					+ numRooms + " " + numBath + " " + backyard + " " + rentZoning + " " + has_secSystem + " " 
					+ has_pool + " " + has_fireplace + " " + value + " ";	
	}
	
	public void printProp(){
		System.out.println(
				""+ CLASSIFICATION + "\n" + address + "\n" + propertyType + "\n" + builtIn + "\n" + squareFoot + "\n"
						+ numRooms + "\n" + numBath + "\n" + backyard + "\n" + rentZoning + "\n" + has_secSystem + "\n" 
						+ has_pool + "\n" + has_fireplace + "\n" + value + "\n");
	}
}

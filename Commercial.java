package agency;
/**
 *	Commercial
 *	subclass of Property
 *	contains the classification Commercial designator
 
 * 	@version 2018.11.20
 *	@author R.Erskine 
 */
public class Commercial extends Property
{
	final private String CLASSIFICATION = "Commercial";
	
	public Commercial(){
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

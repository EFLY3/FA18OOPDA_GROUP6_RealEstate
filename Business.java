package Acme_Realty;

/**
 *	class Business
 *		Business is a Commercial subclass. Business has String companyName and double equipmentCost
 *		
 * created 10/17/18 - R.Erskine
 */
public class Business extends Commercial
{
	private String companyName;
	private double equipmentCost;
	
	public Business()
	{
		super();
		companyName = "";
		equipmentCost = 0;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getEquipmentCost() {
		return equipmentCost;
	}

	public void setEquipmentCost(double equipmentCost) {
		this.equipmentCost = equipmentCost;
	}
	
	@Override
	public String toString() {
		return "Business \n" + companyName + "\n" + address + "\n" + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n" + equipmentCost + "\n";
	}

}

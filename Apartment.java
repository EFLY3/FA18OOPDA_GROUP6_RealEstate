package Acme_Realty;

/**
 *	class Apartment
 *		Apartment is a Property subclass. Apartment represents a single unit to be used in 
 *		an ArrayList for ApartmentBulding.
 *		
 * created 10/17/18 - R.Erskine
 */
public class Apartment extends Property
{
	private int roomNum;
	
	public Apartment()
	{
		super();
		roomNum = 0;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	@Override
	public String toString() {
		return "Apartment \n" + roomNum + "\n" + address + "\n" + builtIn + "\n" + squareFoot + "\n"
				+ numRooms + "\n" + numBath + "\n";
	}

}


import java.util.Comparator;

/**
 *	SortByNumRooms
 *		Using the Comparator interface, this allows us to isolate and compare 
 *		the numbers of rooms(numRooms) of two property classes.
 *
 *	created 10/17/18 - R.Erskine
 */
public class SortByNumRooms implements Comparator<Property>
{

	public int compare(Property a, Property b)
	{
		return a.getNumRooms() - b.getNumRooms();
	}
}
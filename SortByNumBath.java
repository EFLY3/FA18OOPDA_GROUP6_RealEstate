
import java.util.Comparator;

/**
 *	SortByNumBath
 *		Using the Comparator interface, this allows us to isolate and compare 
 *		the numbers of bathrooms(numBath) of two property classes.
 *
 *	created 10/17/18 - R.Erskine
 */
public class SortByNumBath implements Comparator<Property>
{

	public int compare(Property a, Property b)
	{
		return (int) (a.getNumBath() - b.getNumBath());
	}
}
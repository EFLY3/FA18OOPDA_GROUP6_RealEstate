package Acme_Realty;
import java.util.Comparator;

/**
 *	SortBySquareFoot
 *		Using the Comparator interface, this allows us to isolate and compare 
 *		the square footage of two property classes.
 *
 *	created 10/17/18 - R.Erskine
 */
public class SortBySquareFoot implements Comparator<Property>
{

	public int compare(Property a, Property b)
	{
		return a.getSquareFoot() - b.getSquareFoot();
	}
}

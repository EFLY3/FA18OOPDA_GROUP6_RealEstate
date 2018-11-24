
import java.util.Comparator;

/**
 *	SortByBuiltIn
 *		Using the Comparator interface, this allows us to isolate and compare 
 *		the builtIn year of two property classes.
 *
 *	created 10/17/18 - R.Erskine
 */
public class SortByBuiltIn implements Comparator<Property>
{

	public int compare(Property a, Property b)
	{
		return a.getBuiltIn() - b.getBuiltIn();
	}
}

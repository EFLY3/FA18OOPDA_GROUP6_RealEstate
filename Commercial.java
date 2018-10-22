package Acme_Realty;

/**
 *	class Commercial
 *		designates all subclasses as Commercial through final String PROP_TYPE
 *		
 * created 10/17/18 - R.Erskine
 */
public abstract class Commercial extends Property
{
	protected final String PROP_TYPE = "Commercial";
	
	public Commercial()
	{
		super();
	}

	public String getPropType()
	{
		return PROP_TYPE;
	}
}

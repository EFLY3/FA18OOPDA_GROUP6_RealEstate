package Acme_Realty;

/**
 *	class SingleStory
 *		designates all subclasses as SingleStory through final int FLOOR_AMT
 *		
 * created 10/17/18 - R.Erskine
 */
public abstract class SingleStory extends Residential
{
	protected final int FLOOR_AMT = 1;
	
	public SingleStory()
	{
		super();
	}
	
	public int getFloorAmt()
	{
		return FLOOR_AMT;
	}

}

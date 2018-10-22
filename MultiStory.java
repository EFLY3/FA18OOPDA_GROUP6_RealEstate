package Acme_Realty;

/**
 *	class MultiStory
 *		designates all subclasses as MultiStory through int floorAmt
 *		
 * created 10/17/18 - R.Erskine
 */
public abstract class MultiStory extends Residential
{
	protected int floorAmt;
	
	public MultiStory()
	{
		super();
		floorAmt = 0;
	}

	//setters and getters
	public int getFloorAmt() {
		return floorAmt;
	}

	public void setFloorAmt(int floorAmt) {
		this.floorAmt = floorAmt;
	}

}

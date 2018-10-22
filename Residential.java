package Acme_Realty;

/**
 *	class Residential
 *		designates all subclasses as Residential through final String PROP_TYPE
 *		contains the boolean checks for swimmingPool, fireplace, 
 *		
 * created 10/17/18 - R.Erskine
 */
public abstract class Residential extends Property
{
	protected final String PROP_TYPE = "Residential";
	protected boolean has_swimmingPool;
	protected boolean has_fireplace;
	
	public Residential()
	{
		super();
		has_swimmingPool = true;
		has_fireplace = true;
	}

	public String getPropType()
	{
		return PROP_TYPE;
	}

	public boolean isHas_swimmingPool() {
		return has_swimmingPool;
	}

	public void setHas_swimmingPool(boolean has_swimmingPool) {
		this.has_swimmingPool = has_swimmingPool;
	}

	public boolean isHas_fireplace() {
		return has_fireplace;
	}

	public void setHas_fireplace(boolean has_fireplace) {
		this.has_fireplace = has_fireplace;
	}
}

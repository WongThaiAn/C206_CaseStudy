

public class Currency 
{
	private String ISO;
	private String name;
	private double bRate;
	private double sRate;
	private double holding;
	private int threshold;
	
	/**
	 * @return the threshold
	 */
	public int getThreshold() {
		return threshold;
	}



	/**
	 * @param threshold the threshold to set
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}



	public Currency(String ISO, String name, double bRate, double sRate, double holding, int threshold) {
		this.ISO = ISO;
		this.name = name;
		this.bRate = bRate;
		this.sRate = sRate;
		this.holding = holding;
		this.threshold = threshold;
	}

	

	/**
	 * @return the holding
	 */
	public double getHolding() {
		return holding;
	}

	/**
	 * @param holding the holding to set
	 */
	public void setHolding(double holding) {
		this.holding = holding;
	}

	/**
	 * @return the iSO
	 */
	public String getISO() {
		return ISO;
	}

	/**
	 * @param iSO the iSO to set
	 */
	public void setISO(String iSO) {
		ISO = iSO;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bRate
	 */
	public double getbRate() {
		return bRate;
	}

	/**
	 * @param bRate the bRate to set
	 */
	public void setbRate(double bRate) {
		this.bRate = bRate;
	}

	/**
	 * @return the sRate
	 */
	public double getsRate() {
		return sRate;
	}

	/**
	 * @param sRate the sRate to set
	 */
	public void setsRate(double sRate) {
		this.sRate = sRate;
	}


	public boolean getIsAvailable(boolean b) 
	{
		boolean isAvailable = true;
		String available;
		
		if (isAvailable == true) 
		{
			available = "Yes";
			isAvailable=  true;
			
		} 
		else 
		{
			available = "No";
			isAvailable = false;
		
		}
		return isAvailable;
	}
	
	public void displayCurrency()
	{
		System.out.println("Name: "+name);
		System.out.println("ISO: " +ISO);
		System.out.println("Buying Rate: "+ bRate);
		System.out.println("Selling Rate: "+ sRate);
		System.out.println("Holding: "+holding);
	}



	
}




/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Wong Thai An, 29 Jul 2021 2:48:17 pm
 */

/**
 * @author 20017757
 *
 */
public class Currency {
	private String ISO;
	private String name;
	private double bRate;
	private double sRate;
	private double holding;
	
	public Currency(String ISO, String name, double bRate, double sRate, double holding) {
		this.ISO = ISO;
		this.name = name;
		this.bRate = bRate;
		this.sRate = sRate;
		this.holding = holding;
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
	
	
}

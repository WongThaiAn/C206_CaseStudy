
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * royci, 9 Aug 2021 11:02:54 pm
 */

public class Buy_Transaction {
	private int buyID;
	private String buytxTime;
	private double buyAmt;

	public Buy_Transaction(int buyID, String buytxTime, double buyAmt) {
		this.buyID = buyID;
		this.buytxTime = buytxTime;
		this.buyAmt = buyAmt;
	}

	public double getBuyAmt() {
		return buyAmt;
	}

	public String getBuytxTime() {
		return buytxTime;
	}

	public void setBuytxTime(String buytxTime) {
		this.buytxTime = buytxTime;

	}

	public void setBuyAmt(double buyAmt) {
		this.buyAmt = buyAmt;
	}

	public int getBuyID() {
		return buyID;
	}

}

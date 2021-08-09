
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * royci, 9 Aug 2021 11:02:54 pm
 */

public class Buy_Transaction {
	private int buyID;
	private double buyAmt;

	public Buy_Transaction(int buyID, double buyAmt) {
		this.buyID = buyID;
		this.buyAmt = buyAmt;
	}

	public double getBuyAmt() {
		return buyAmt;
	}

	public void setBuyAmt(double buyAmt) {
		this.buyAmt = buyAmt;
	}

	public int getBuyID() {
		return buyID;
	}

}

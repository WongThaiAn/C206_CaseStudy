
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * royci, 9 Aug 2021 5:16:38 pm
 */

public class Sell_Transaction {
	private int sellID;
	private double sellAmt;

	public Sell_Transaction(int sellID, double sellAmt) {
		this.sellID = sellID;
		this.sellAmt = sellAmt;
	}

	public double getSellAmt() {
		return sellAmt;
	}

	public void setSellAmt(double sellAmt) {
		this.sellAmt = sellAmt;
	}

	public int getSellID() {
		return sellID;
	}

}

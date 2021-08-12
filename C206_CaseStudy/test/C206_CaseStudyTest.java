import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currency c1;
	private Currency c2;

	private Sell_Transaction s1;
	private Sell_Transaction s2;

	private Buy_Transaction b1;
	private Buy_Transaction b2;

	private ArrayList<Currency> currencyList;

	private ArrayList<Sell_Transaction> SellList;

	private ArrayList<Buy_Transaction> BuyList;

	public C206_CaseStudyTest() {
		super();

	}

	@Before

	public void setUp() throws Exception {
//		c1 = new Currency("3166", "RM", 3.12, 0.32, 10000);
//		c2 = new Currency("840", "USD", 0.74, 1.35, 5000);

		c1 = new Currency("702", "SGD", 1, 1, 9999999, 0);
		c2 = new Currency("3166", "RM", 0.34, 0.32, 10000, 0);

		currencyList = new ArrayList<Currency>();

		s1 = new Sell_Transaction(1, 100);
		s2 = new Sell_Transaction(2, 500);

		SellList = new ArrayList<Sell_Transaction>();

		b1 = new Buy_Transaction(1, "Thursday 12 August 2021, 12:00 pm", 100);
		b2 = new Buy_Transaction(2, "Thursday 12 August 2021, 12:07 pm", 500);

		BuyList = new ArrayList<Buy_Transaction>();
	}

	@Test
	public void addHoldingTest() {
		// Test if currency list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to add to", currencyList);
		// Given an empty list after adding 1 currency, the size of the list is 1 -
		// normal
		// The currency holding added is the same as the first currency of the list
	}

	@Test
	public void retrieveHoldingTest() {
		// Test if currency list is not null but empty - boundary
		assertNotNull("Check if there is a valid Currency arraylist to retrieve holding", currencyList);
		// Test if the list of Currency retrieved from the C206_CaseStudy is empty -
		// boundary
		String allCurrency = C206_CaseStudy.retrieveHolding(currencyList);
		String testOutput = "";
		assertEquals("Check that ViewAllCurrency", testOutput, allCurrency);
		// test if the expected output string same as the list of currency retrieved
		// from the C206_CaseStudy
		allCurrency = C206_CaseStudy.retrieveHolding(currencyList);
		testOutput = String.format("%-10s %-s\n", "SGD", "10000");
		testOutput += String.format("%-10s %-s\n", "USD", "5000");
		assertEquals("Test that ViewAllCurrency", testOutput, allCurrency);
	}

	@Test
	public void deleteHoldingTest() {
		// Test if currency list is not null, so that can delete a item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to delete from", currencyList);
	}

	@Test
	public void addCurrencyTest() {
		// Currency list is not null, so that can add new currency
		assertNotNull("Test if there is a valid currency list to add to", currencyList);
		assertEquals("Test if the currency arrayList size is 0", 0, currencyList.size());

		// Given an empty list, after adding 1 currency, the size of the list is 1 -
		// normal
		// The currency just added is as same as the first currency of the list
		C206_CaseStudy.addCurrency(currencyList, c1);
		assertEquals("Check that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", c1, currencyList.get(0));

		// Add another currency. test The size of the list is 2? -normal
		// The currency just added is as same as the second item of the list
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertEquals("Check that Currency arraylist size is 1", 2, currencyList.size());
		// assertEquals("Check that currency size is 2", 2, currency.size());

		assertSame("Check that Currency is added", c1, currencyList.get(0));
	}

	@Test
	public void retrieveAllCurrencyTest() {
		// Test if currency list is not null but empty
		assertNotNull("Test if there is a valid Currency arraylist to retrieve currency details", currencyList);

		// Test if the list of Currency retrieved from the C206_CaseStudy is empty -
		// boundary
		String allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
		String testOutput = "";
		assertEquals("Test that the viewAllCurrency", testOutput, allCurrency);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addCurrency(currencyList, c1);
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertEquals("Test that Currency arraylist size is 2", 2, currencyList.size());

		// test if the expected output string same as the list of currency retrieved
		// from the SourceCentre
		allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
		testOutput = String.format("%-10s %-10s %-10s %-10s %-10s\n", "702", "SGD", "0.7", "1.3", "10000");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-20s\n", "840", "USD", "1.3", "0.7", "5000");

		assertEquals("Test that ViewAllCurrency", testOutput, allCurrency);

	}

	@Test
	public void viewCompanyholdingTest() {
		// Test if currency list is not null but empty
		assertNotNull("Test if there is a valid Currency arraylist to view company holdings in various currencies",
				currencyList);
		assertEquals("Test that currencyList arraylist size is 2", 2, currencyList.size());

		String allHolding = C206_CaseStudy.retrieveHolding(currencyList);
		String testOutput = "";
		assertEquals("Test that the retrieved Holding is empty?", testOutput, allHolding);

	}

	@Test
	public void viewSGDvalueTest() {
		// Test if currency list is not null, so that can delete a item
		assertNotNull(
				"Check if there is a valid Currency arraylist to display currency in SGD value based on sell rate",
				currencyList);
		assertEquals("Test that currencyList arraylist size is 2", 2, currencyList.size());

	}

	@Test
	public void searchCurrencyholdingTest() {
		assertNotNull(
				"Test if there is a valid Currency arraylist to search " + "for the currency Holding and its SGD value",
				currencyList);
		String testOutput = "";
		testOutput = String.format("%-10s %-10s %-10s %-10s %-10s\n", "702", "SGD", "0.7", "1.3", "10000");
		testOutput = String.format("%-10s %-10s %-10s %-10s %-20s\n", "840", "USD", "1.3", "0.7", "5000");
		assertEquals("Test that Searched currencyList is empty?", testOutput,
				C206_CaseStudy.searchCurrencyholding(currencyList));

		boolean test1 = C206_CaseStudy.searchCurrencyholding(currencyList);
		assertTrue("Test if Search Currency Holding is available to find for holding and its SGD value ", test1);

	}

	@Test
	public void addSelltxTest() {
		// Sell list is not null, so that can add new sell transaction
		assertNotNull("Test if there is a valid sell list to add to", SellList);
		assertEquals("Test if the sell arrayList size is 0", 0, SellList.size());

		// Given an empty list, after adding 1 sell transaction, the size of the list is
		// 1 -
		// normal
		// The sell transaction just added is as same as the first sell transaction of
		// the
		// list
		C206_CaseStudy.addSelltx(SellList, s1);
		assertEquals("Check that sell arraylist size is 1", 1, SellList.size());
		assertSame("Check that sell transaction is added", s1, SellList.get(0));

		// Add another sell transaction. test The size of the list is 2? -normal
		// The sell transaction just added is as same as the second item of the list
		C206_CaseStudy.addSelltx(SellList, s2);
		assertEquals("Check that sell arraylist size is 2", 2, SellList.size());
		// assertEquals("Check that sell transaction size is 2", 2, currency.size());

		assertSame("Check that Sell transaction is added", s2, SellList.get(1));
	}

	@Test
	public void addBuytxTest() {
		// Buy list is not null, so that can add new buy transaction
		assertNotNull("Test if there is a valid buy list to add to", BuyList);
		assertEquals("Test if the buy arrayList size is 0", 0, BuyList.size());

		// Given an empty list, after adding 1 buy transaction, the size of the list is
		// 1 -
		// normal
		// The buy transaction just added is as same as the first buy transaction of the
		// list
		C206_CaseStudy.addBuytx(BuyList, b1);
		assertEquals("Check that buy arraylist size is 1", 1, BuyList.size());
		assertSame("Check that buy transaction is added", b1, BuyList.get(0));

		// Add another buy transaction. test The size of the list is 2? -normal
		// The buy transaction just added is as same as the second item of the list
		C206_CaseStudy.addBuytx(BuyList, b2);
		assertEquals("Check that buy arraylist size is 2", 2, BuyList.size());
		// assertEquals("Check that buy transaction size is 2", 2, currency.size());

		assertSame("Check that Buy transaction is added", b2, BuyList.get(1));
	}

}

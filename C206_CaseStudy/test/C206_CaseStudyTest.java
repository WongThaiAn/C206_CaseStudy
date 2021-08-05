import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currency c1;
	private Currency c2;
	
	private ArrayList<Currency> currencyList;
	
	public C206_CaseStudyTest() {
		super();
	}
	@Before
	
	public void setUp() throws Exception {
		c1 = new Currency("3166","RM", 3.12, 0.32, 10000);
		c2 = new Currency("840", "USD", 0.74, 1.35, 5000);
		
		currencyList = new ArrayList<Currency>();
	}
	
	@Test
	public void addHoldingTest() {
		// Test if currency list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to add to",currencyList);
		//Given an empty list after adding 1 currency, the size of the list is 1 - normal
		//The currency holding added is the same as the first currency of the list
	}
	@Test
	public void retrieveHoldingTest() {
		//Test if currency list is not null but empty - boundary
		assertNotNull("Check if there is a valid Currency arraylist to retrieve holding",currencyList);
		//Test if the list of Currency retrieved from the C206_CaseStudy is empty - boundary
		String allCurrency = C206_CaseStudy.retrieveHolding(currencyList);
		String testOutput = "";
		assertEquals("Check that ViewAllCurrency",testOutput,allCurrency);
		//test if the expected output string same as the list of currency retrieved from the C206_CaseStudy
		allCurrency = C206_CaseStudy.retrieveHolding(currencyList);
		testOutput = String.format("%-10s %-s\n","SGD","10000");
		testOutput += String.format("%-10s %-s\n", "USD","5000");
		assertEquals("Test that ViewAllCurrency",testOutput,allCurrency);
	}
	
	@Test
	public void deleteHoldingTest() {
		// Test if currency list is not null, so that can delete a item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to delete from",currencyList);
	}
	
	@Test
	public void addCurrencyTest() {
		//Currency list is not null, so that can add new currency
		assertNotNull("Test if there is a valid currency list to add to", currencyList);
		assertEquals("Test if the currency arrayList size is 0", 0,currencyList.size());
		
		
		//Given an empty list, after adding 1 currency, the size of the list is 1 - normal
		//The currency just added is as same as the first currency of the list
		C206_CaseStudy.addCurrency(currencyList, c1);
		assertEquals("Check that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", c1, currencyList.get(0));
		
		//Add another currency. test The size of the list is 2? -normal
		//The currency just added is as same as the second item of the list
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertEquals("Check that Currency arraylist size is 1", 2, currencyList.size());
		//assertEquals("Check that currency size is 2", 2, currency.size());
		
		assertSame("Check that Currency is added", c1, currencyList.get(0));
	}
	
	@Test
	public void retrieveAllCurrencyTest() {
		//Test if currency list is not null but empty
		assertNotNull("Test if there is a valid Currency arraylist to retrieve currency details",currencyList);
		
		//Test if the list of Currency retrieved from the C206_CaseStudy is empty - boundary
		String allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
		String testOutput = "";
		assertEquals("Test that the viewAllCurrency",testOutput,allCurrency);
		
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCurrency(currencyList, c1);
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertEquals("Test that Currency arraylist size is 2", 2, currencyList.size());
				
		//test if the expected output string same as the list of currency retrieved from the SourceCentre	
		allCurrency= C206_CaseStudy.retrieveAllCurrency(currencyList);
		testOutput = String.format("%-10s %-10s %-10s %-10s %-10s\n","702", "SGD", "0.7", "1.3", "10000");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-20s\n","840", "USD", "1.3", "0.7", "5000" );
			
		assertEquals("Test that ViewAllCurrency", testOutput, allCurrency);
	
	}
	
	@Test
	public void viewAllCurrencyListTest() {
		//Test if currency list is not null but empty
				assertNotNull("Test if there is a valid Currency arraylist to view currency details",currencyList);
		
	}
	
	@Test
	public void deleteCurrencyTest() {
		// Test if currency list is not null, so that can delete a item
		assertNotNull("Check if there is a valid Currency arraylist to delete from",currencyList);
			
		
	}
	
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}

	

}

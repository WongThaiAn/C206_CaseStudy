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
		c1 = new Currency(702,"SGD", 0.7, 1.3, 10000);
		c2 = new Currency(840, "USD", 1.3, 0.7, 5000);
		
		currencyList = new ArrayList<Currency>();
	}
	
	@Test
	public void addHoldingTest() {
		// Test if currency list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to add to",currencyList);
				
	}
	@Test
	public void retrieveHoldingTest() {
		//Test if currency list is not null but empty - boundary
		assertNotNull("Check if there is a valid Currency arraylist to retrieve holding",currencyList);
		//Test if the list of Currency retrieved from the C206_CaseStudy is empty - boundary
		String allCurrency = C206_CaseStudy.retrieveHolding(currencyList);
		String testOutput = "";
		assertEquals("Test that the retrieved CurrencyList is empty?",testOutput);
		
		//Given an empty list, after adding 2 currency, test if the size of the list is 2 - normal
	}
	
	@Test
	public void deleteHoldingTest() {
		// Test if currency list is not null, so that can delete a item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to delete from",currencyList);
	}

	public void addCurrencyTest() {
		//Currency list is not null, so that can add new currency
		assertNotNull("Test if there is a valid currency list to add to", currencyList);
		assertEquals("Test if the currency arrayList size is 0", 0,currencyList.size());
		
		//Given that the list is empty, after adding 2 currency, the size of the list is 1
		C206_CaseStudy.addCurrency(currencyList);
		assertEquals("Test that currencyList size is 2", 2, currencyList.size());
		
		// The item just added is the same as the last currency
		assertSame("Test that currency added is the same as the last currency in the list?", c2, currencyList.get(1));
		
	}
	public void retrieveAllCurrencyTest() {
		//Test if currency list is not null but empty
		assertNotNull("Test if there is a valid Currency arraylist to retrieve currency details",currencyList);
		
		//Test if the list of Currency retrieved from the C206_CaseStudy is empty
		String Output = "";
		String allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
		assertEquals("Test that the retrieved CurrencyList is empty?",Output);
		
		
	}
	public void viewAllCurrencyListTest() {
		//Test if currency list is not null but empty
				assertNotNull("Test if there is a valid Currency arraylist to view currency details",currencyList);
		
	}
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

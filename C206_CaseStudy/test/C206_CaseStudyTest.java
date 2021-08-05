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
		c1 = new Currency("702","SGD", 0.7, 1.3, 10000);
		c2 = new Currency("840", "USD", 1.3, 0.7, 5000);
		
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

	public void addCurrencyTest() {
		//Currency list is not null, so that can add new currency
		assertNotNull("Test if there is a valid currency list to add to", currencyList);
		assertEquals("Test if the currency arrayList size is 0", 0,currencyList.size());
		
	}
	
	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}

	

}

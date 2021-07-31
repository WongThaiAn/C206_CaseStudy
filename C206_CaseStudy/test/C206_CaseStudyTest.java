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
	public void addHoldingsTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid Currency arraylist to add to");
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		//C206_CaseStudy.addHolding(currencyList,c1);

				
		
	}

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}

	

}

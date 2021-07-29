import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Currency> currencyList = new ArrayList<Currency>();

		int option = 0;

		while (option != 15) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.addCurrency(currencyList);
			} else if (option == 2) {
				C206_CaseStudy.viewAllCurrency(currencyList);
			} else if (option == 3) {
				C206_CaseStudy.deleteCurrency(currencyList);
			} else if (option == 4) {
				C206_CaseStudy.addHolding(currencyList);
			} else if (option == 5) {
				C206_CaseStudy.viewHolding(currencyList);
			} else if (option == 6) {
				C206_CaseStudy.deleteHolding(currencyList);
			} else if (option == 7) {
				C206_CaseStudy.viewCompanyholding(currencyList);
			} else if (option == 8) {
				C206_CaseStudy.viewSGDvalue(currencyList);
			} else if (option == 9 ) {
				C206_CaseStudy.searchCurrencyholding(currencyList);
			} else if (option == 10) {
				C206_CaseStudy.searchBuySellrate(currencyList);
			} else if (option == 11) {
				C206_CaseStudy.calculateConvert(currencyList);
			} else if (option == 12) {
				C206_CaseStudy.addTransaction(currencyList);
			}else if (option == 15) {
				System.out.println("Bye");
			}
			
		}
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
		System.out.println("1. Add currency");
		System.out.println("2. View currency");
		System.out.println("3. Delete currency");
		System.out.println("4. Add holding");
		System.out.println("5. View holding");
		System.out.println("6. Delete holding");
		System.out.println("7. View company holding");
		System.out.println("8. Display converted SGD value");
		System.out.println("9. Search for currency holding and its SGD value");
		System.out.println("10. Search for buy and sell rate of currency");
		System.out.println("11. Currency Converter Calculator");
		System.out.println("12. Record buying transaction");
	}

	private static void addCurrency(ArrayList<Currency> currencyList) {

	}

	private static void viewAllCurrency(ArrayList<Currency> currencyList) {

	}

	private static void deleteCurrency(ArrayList<Currency> currencyList) {

	}

	private static void addHolding(ArrayList<Currency> currencyList) {

	}
	private static void viewHolding(ArrayList<Currency> currencyList) {
		
	}
	private static void deleteHolding(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}
	private static void viewCompanyholding(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}
	private static void viewSGDvalue(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}
	private static void searchCurrencyholding(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}
	private static void searchBuySellrate(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}
	private static void calculateConvert(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}
	private static void addTransaction(ArrayList<Currency> currencyList) {
		// TODO Auto-generated method stub
		
	}


}

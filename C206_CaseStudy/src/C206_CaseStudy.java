import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	private static final ArrayList<Currency> currencyList = new ArrayList<Currency>();
	private static final ArrayList<Sell_Transaction> SellList = new ArrayList<Sell_Transaction>();
	private static final ArrayList<Buy_Transaction> BuyList = new ArrayList<Buy_Transaction>();

	private static String currName;

	public static void main(String[] args) {

//		currencyList.add(new Currency("702", "SGD", 1, 1, 9999999, 0));
//		currencyList.add(new Currency("3166", "RM", 3.12, 0.32, 10000, 0));
//		currencyList.add(new Currency("840", "USD", 0.74, 1.35, 5000, 0));

		currencyList.add(new Currency("702", "SGD", 1, 1, 9999999, 0));
		currencyList.add(new Currency("3166", "RM", 3.14, 3.12, 10000, 0));
		currencyList.add(new Currency("840", "USD", 0.80, 0.74, 5000, 0));

		int option = 0;

		while (option != 15) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				Currency cc = inputCurrency();
				C206_CaseStudy.addCurrency(currencyList, cc);

			}

			else if (option == 2) {
				C206_CaseStudy.viewAllCurrency(currencyList);
			}

			else if (option == 3) {
				C206_CaseStudy.deleteCurrency(currencyList);
			}

			else if (option == 4) {
				C206_CaseStudy.addHolding(currencyList);
			}

			else if (option == 5) {
				C206_CaseStudy.viewHolding(currencyList);
			}

			else if (option == 6) {
				C206_CaseStudy.deleteHolding(currencyList);
			}

			else if (option == 7) {
				C206_CaseStudy.viewCompanyholding(currencyList);
			}

			else if (option == 8) {
				C206_CaseStudy.viewSGDvalue(currencyList);
			}

			else if (option == 9) {
				C206_CaseStudy.searchCurrencyholding(currencyList);
			}

			else if (option == 10) {
				C206_CaseStudy.searchBuySellrate(currencyList);
			}

			else if (option == 11) {
				C206_CaseStudy.calculateConvert(currencyList);
			}

			else if (option == 12) {
				Sell_Transaction st = inputSelltx();
				C206_CaseStudy.addSelltx(SellList, st);

			} else if (option == 13) {
				Buy_Transaction bt = inputBuytx();
				C206_CaseStudy.addBuytx(BuyList, bt);

			} else if (option == 14) {
				C206_CaseStudy.viewAllBuytx(BuyList);

			} else if (option == 15) {
				C206_CaseStudy.viewaddthreshold(currencyList);

			} else if (option == 16) {
				C206_CaseStudy.UpdateCurrency(currencyList);

			}
		}

		if (option == 20)
			System.out.println("Bye");

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
		System.out.println("8. Display converted SGD value based on sell rate");
		System.out.println("9. Search for currency holding and its SGD value");
		System.out.println("10. Search for buy and sell rate of currency");
		System.out.println("11. Currency Converter Calculator");
		System.out.println("12. Record selling transaction");
		System.out.println("13. Record buying transaction");
		System.out.println("14. View buying transaction");
		System.out.println("15. View and add threshold");
		System.out.println("16. Update Currency");
		System.out.println("20. Bye");
	}

	public static Currency inputCurrency() {
		// done by syahira
		C206_CaseStudy.setHeader("Add Currency");
		String iso = Helper.readString("Enter ISO: ");
		String name = Helper.readString("Enter Name: ");
		Double bRate = Helper.readDouble("Enter Buy Rate: ");
		Double sRate = Helper.readDouble("Enter Sell Rate: ");
		Double holding = (double) 0;
		int threshold = 0;

		Currency cc = new Currency(iso, name, bRate, sRate, holding, threshold);
		return cc;

	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency cc) {
		// done by syahira
		currencyList.add(cc);
		System.out.println(cc.getName() + " has been added");
	}

	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		// done by syahira
		C206_CaseStudy.setHeader("Currency LIST");
		String output = String.format("%-10s %-10s %-10s %-10s %-10s\n", "ISO", "NAME", "BUY RATE", "SELL RATE",
				"HOLDING");
		output += retrieveAllCurrency(currencyList);
		System.out.println(output);
	}

	public static String retrieveAllCurrency(ArrayList<Currency> currencyList) {
		// done by syahira
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {

			output += String.format("%-10s %-10s %-10.2f %-10.2f %-10.2f\n", currencyList.get(i).getISO(),
					currencyList.get(i).getName(), currencyList.get(i).getbRate(), currencyList.get(i).getsRate(),
					currencyList.get(i).getHolding());

		}
		return output;
	}

	public static void deleteCurrency(ArrayList<Currency> currencyList) {
		// done by syahira
		C206_CaseStudy.setHeader("Delete Currency");
		boolean Ismatch = false;
		String iso = Helper.readString("Enter Currency ISO: ");
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO().contains(iso)) {
				String confirm = Helper.readString("Are you sure? YES/NO : ");
				if (confirm.toUpperCase().contains("YES")) {
					currencyList.remove(i);
					System.out.println("ISO " + iso + " has been deleted");
					Ismatch = true;

				}
			}
		}
		if (!Ismatch) {
			System.out.println("No such ISO");
		}
	}

	private static void UpdateCurrency(ArrayList<Currency> currencyList) {
		// done by Syahira
		// TODO Auto-generated method stub
		String iso = Helper.readString("Enter Currency ISO: ");
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO().contains(iso)) {
				System.out.println("1. Update Buy Rate");
				System.out.println("2. Update Sell Rate");
				int choice = Helper.readInt("Enter choice: ");
				if (choice == 1) {
					Double newBuyRate = Helper.readDouble("Enter new Buy Rate: ");
					currencyList.get(i).setbRate(newBuyRate);
					System.out.println(
							"ISO " + currencyList.get(i).getISO() + " has change the buy rate to " + newBuyRate);

				} else if (choice == 2) {
					Double newSellRate = Helper.readDouble("Enter new Sell Rate: ");
					currencyList.get(i).setsRate(newSellRate);
					System.out.println(
							"ISO " + currencyList.get(i).getISO() + " has change the sell rate to " + newSellRate);
				}
			} else {
				System.out.println("No such ISO");
			}
		}
	}

	public static void addHolding(ArrayList<Currency> currencyList) {

		C206_CaseStudy.setHeader("Add Holding");
		String iso = Helper.readString("Enter Currency ISO: ");
		boolean match = false;
		boolean under = false;
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO().equals(iso)) {
				match = true;
				double holding = Helper.readDouble("Enter holding amount to add: ");
				if (holding + currencyList.get(i).getHolding() < currencyList.get(i).getThreshold()) {
					currencyList.get(i).setHolding(currencyList.get(i).getHolding() + holding);
					System.out.println(holding + "" + currencyList.get(i).getName() + " has been added");
					under = true;
				}
			}
		}
		if (under) {
			System.out.println("Successfully added");
		}

		if (!match) {
			System.out.println("No such ISO");
		}
		if (!under) {
			System.out.println("Over the threshold");
		}
	}

	public static String retrieveHolding(ArrayList<Currency> currencyList) {
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {
			output += String.format("%-10s %.2f\n", currencyList.get(i).getName(), currencyList.get(i).getHolding());
		}
		return output;
	}

	public static void viewHolding(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("View Holding");
		String output = String.format("%-10s %s\n", "Name", "Holding");
		output += retrieveHolding(currencyList);
		System.out.println(output);

	}

	public static void deleteHolding(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("Delete Holding");
		boolean match = false;
		String iso = Helper.readString("Enter Currency ISO: ");
		double holding = Helper.readDouble("Enter holding amount to delete: ");

		if (holding == 0 || holding < 0) {
			System.out.println("Holding amount invalid");
		} else {

			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(iso)) {
					currencyList.get(i).setHolding(currencyList.get(i).getHolding() - holding);
					System.out.println(holding + "" + currencyList.get(i).getName() + " has been deleted");
					match = true;
				}
			}
		}

		if (!match) {
			System.out.println("No such ISO");
		}

	}

	public static String retrievethreshold(ArrayList<Currency> currencyList) {
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {
			output += String.format("%-10s %d\n", currencyList.get(i).getName(), currencyList.get(i).getThreshold());
		}
		return output;
	}

	public static void viewaddthreshold(ArrayList<Currency> currencyList) {
		boolean match = false;
		C206_CaseStudy.setHeader("View Holding");
		String output = String.format("%-10s %s\n", "Name", "Threshhold");
		output += retrievethreshold(currencyList);
		System.out.println(output);
		char proceed = Helper.readChar("Proceed with adding threshold? (y/n): ");
		if (proceed == 'y') {
			String iso = Helper.readString("Enter Currency ISO: ");
			int threshold = Helper.readInt("Enter threshold: ");
			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(iso)) {
					currencyList.get(i).setThreshold(threshold);
					match = true;
				}
			}
			if (match) {
				System.out.println("Successfully added");
			}
			if (!match) {
				System.out.println("No such ISO");
			}
		} else {
			System.out.println("Thank you");
		}

	}

	public static void viewCompanyholding(ArrayList<Currency> currencyList) {
		// Done by Perry

		C206_CaseStudy.setHeader("VIEW COMPANY'S HOLDING IN VARIOUS CURRENCIES BASED ON SELL RATE");

		String holdingoutput1 = "";
		double convertedholding = 0.0;
		int i = 0;

		String holdingoutput = String.format("%-10s %-10s %-10s\n", "HOLDING", "SGD VALUE", "FOREIGN CURRENCY");

		System.out.println(holdingoutput);

		for (i = 0; i < currencyList.size(); i++) {
			Currency currency = currencyList.get(i);
			convertedholding = currency.getHolding() * currency.getsRate();
			holdingoutput1 += String.format("%-10s %-10.2f %-10.2f\n", currency.getName(), currency.getHolding(),
					convertedholding);

		}

		System.out.println(holdingoutput1);

	}

	public static void viewSGDvalue(ArrayList<Currency> currencyList) {
		// Done by Perry

		C206_CaseStudy.setHeader("DISPLAY CURRENCY IN ITS CONVERTED SGD VALUE BASED ON SELL RATE");

		String sgdoutput1 = "";
		double sellratesgdholding = 0.0;

		String headingoutput = String.format("%-10s %-20s %-20s %-20s\n", "ISO", "CURRENCY", "SELL RATE",
				"SGD VALUE(SELL RATE)");
		System.out.print(headingoutput);

		for (int i = 0; i < currencyList.size(); i++) {
			Currency currency = currencyList.get(i);
			sellratesgdholding = currency.getHolding() / currency.getsRate();
			sgdoutput1 += String.format("%-10s %-20s %-20.2f %-20.2f\n", currency.getISO(), currency.getName(),
					currency.getsRate(), sellratesgdholding);

		}
		System.out.println(sgdoutput1);

	}

	public static boolean searchCurrencyholding(ArrayList<Currency> currencyList) {
		// Done by Perry
		C206_CaseStudy.setHeader("SEARCH FOR THE CURRENCY HOLDING AND ITS SGD VALUE");

		boolean searchholding = false;
		String output = "";

		double sellratesgdholding = 0.0;
		double buyratesgdholding = 0.0;

		double holdingSearch = Helper.readDouble("Enter Holding to search > ");
		String headingoutput = String.format("%-20s %-30s %-30s", "HOLDING", "SGD VALUE(BUY RATE)",
				"SGD VALUE(SELL RATE)");
		System.out.println(headingoutput);

		for (int i = 0; i < currencyList.size(); i++) {
			Currency currency = currencyList.get(i);

			if (currency.getHolding() == holdingSearch) {

				searchholding = true;
				sellratesgdholding = holdingSearch / currency.getsRate();
				buyratesgdholding = holdingSearch * currency.getbRate();
				output = String.format("%-20.2f %-30.2f %-30.2f\n", holdingSearch, buyratesgdholding,
						sellratesgdholding);

			}

		}
		System.out.println(output);

		if (searchholding == false) {
			System.out.println("Sorry, we do not have the holding that you are looking for!");
		}

		return searchholding;

	}

	public static void searchBuySellrate(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("Search Buy & Sell rate currency");
		int iso = Helper.readInt("Enter currency ISO> ");
		String output = String.format("%-15s %-15s %-15s %-15s\n", "CURRENCY ISO", "CURRENCY NAME", "BUY RATE",
				"SELL RATE");
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO().equals(iso)) {
				output += String.format("%-15d %-15s %-15.2f %-15.2f\n", currencyList.get(i).getISO(),
						currencyList.get(i).getName(), currencyList.get(i).getbRate(), currencyList.get(i).getsRate());
			}
		}
		System.out.println(output);
	}

	public static void calculateConvert(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("Currency Converter Calculator");
		System.out.println("1. Sell Currency");// customer buy currency to us
		System.out.println("2. Buy Currency");// customer sell currency to us
		int option = Helper.readInt("Enter option> ");
		double buyamt = 0.0;
		double sellamt = 0.0;
		double convertamt = 0.0;
		String name = "";
		String aName = "";
		String output = "";
		if (option == 1) {
			String iso = Helper.readString("Enter currency ISO you want to sell to customer> ");
			String buyiso = Helper.readString("Enter currency ISO you want to buy from customer> ");
			int amount = Helper.readInt("Enter amount of currency you want to exchange> ");
			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(iso)) {
					buyamt = currencyList.get(i).getbRate();
					name = currencyList.get(i).getName();
				}
				if (currencyList.get(i).getISO().equals(buyiso)) {
					sellamt = currencyList.get(i).getsRate();
					aName = currencyList.get(i).getName();
				}
				convertamt = (amount * buyamt) * sellamt;
				output = String.format("Converted amount from %s to %s is $%-1.2f", name, aName, convertamt);
			}
			System.out.println(output);
		} else if (option == 2) {
			String iso = Helper.readString("Enter currency ISO you want to buy from customer> ");
			String selliso = Helper.readString("Enter currency ISO you want to sell to customer> ");
			int amount = Helper.readInt("Enter amount of currency you want to exchange> ");
			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(iso)) {
					sellamt = currencyList.get(i).getsRate();
					name = currencyList.get(i).getName();
				}
				if (currencyList.get(i).getISO().equals(selliso)) {
					buyamt = currencyList.get(i).getbRate();
					aName = currencyList.get(i).getName();
				}
				convertamt = (amount * sellamt) * buyamt;
				output = String.format("Converted amount from %s to %s is $%-1.2f", name, aName, convertamt);

			}
			System.out.println(output);
		}
	}

	public static Sell_Transaction inputSelltx() { // Option 12 Record Sell transaction
		// done by roy
		C206_CaseStudy.setHeader("Add Sell Transaction Records");

		double sellrate = 0.0;
		int AmtRec = Helper.readInt("Enter currency amount in SGD received: ");

		if (AmtRec < 0) {
			System.out.println("Error, please enter a positive amount!");
		} else {
			String selliso = Helper.readString("Enter currency ISO you want to sell to customer: ");

			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(selliso)) {
					sellrate = currencyList.get(i).getsRate();
					currName = currencyList.get(i).getName();
				}

			}
			double AMT_OUT = AmtRec * sellrate;

			// Update Holding amount for sell transaction;
			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(selliso)) {
					currencyList.get(i).setHolding(currencyList.get(i).getHolding() - AMT_OUT);
					System.out.println("Total company holding amount for " + currName + " is "
							+ currencyList.get(i).getHolding() + " " + currName + " updated!");
				}
			}
			System.out.println("Sell Transaction record updated!\n");

			Sell_Transaction st = new Sell_Transaction(SellList.size() + 1, AMT_OUT);
			return st;

		}
		return null;

	}

	public static void addSelltx(ArrayList<Sell_Transaction> SellList, Sell_Transaction st) { // Option 12 converted
																								// message for Record
																								// Sell transaction
		// done by roy
		SellList.add(st);
		System.out.format("Amount given out to customer from SGD is %.2f %s\n", st.getSellAmt(), currName);

	}

	// Buy Transaction

	public static Buy_Transaction inputBuytx() { // Option 13 Record Buy transaction
		// done by Roycious
		C206_CaseStudy.setHeader("Add Buy Transaction Records");

		double buyrate = 0.0;
		String buyiso = Helper.readString("Enter foreign currency ISO you want to buy from customer: ");
		int AmtRec = Helper.readInt("Enter foreign currency amount received: ");

		if (AmtRec < 0) {
			System.out.println("Error, please enter a positive amount!");

		} else {
			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(buyiso)) {
					buyrate = currencyList.get(i).getbRate();
					currName = currencyList.get(i).getName();
				}

			}
			double AMT_OUT = AmtRec / buyrate;

			// Update Holding amount for buy transaction;
			for (int i = 0; i < currencyList.size(); i++) {
				if (currencyList.get(i).getISO().equals(buyiso)) {
					currencyList.get(i).setHolding(currencyList.get(i).getHolding() - AMT_OUT);
					System.out.format("Total company holding amount for %s is %.2f %s updated!\n", currName,
							currencyList.get(i).getHolding(), currName);

				}
			}
			System.out.println("Buy Transaction record updated!\n");

			LocalDateTime DT = LocalDateTime.now();
			LocalDateTime txDateTime = LocalDateTime.of(DT.getYear(), DT.getMonth(), DT.getDayOfMonth(), DT.getHour(),
					DT.getMinute());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy, hh:mm a ");

			String buyTime = txDateTime.format(formatter);

			System.out.println(buyTime);

			Buy_Transaction bt = new Buy_Transaction(BuyList.size() + 1, buyTime, AMT_OUT);
			return bt;

		}
		return null;

	}

	public static void addBuytx(ArrayList<Buy_Transaction> BuyList, Buy_Transaction bt) { // Option 13 converted message
																							// for Record Buy
																							// transaction
		// done by Roycious
		BuyList.add(bt);
		System.out.format("Amount given out to customer from %s is %.2f SGD\n", currName, bt.getBuyAmt());

	}

	public static void viewAllBuytx(ArrayList<Buy_Transaction> BuyList) { // Option 14 View Buy transaction Main
		// done by Roycious
		C206_CaseStudy.setHeader("View Buying Transaction");
		String output = String.format("%-5s %-35s %-10s\n", "ID", "Transaction Time", "Buy Amount");
		output += retrieveAllBuytx(BuyList);
		System.out.println(output);
	}

	public static String retrieveAllBuytx(ArrayList<Buy_Transaction> BuyList) { // Option 14 View Buy transaction Main
		// done by Roycious
		String output = "";

		for (int i = 0; i < BuyList.size(); i++) {

			output += String.format("%-5s %-35s %-1.2f %s\n", BuyList.get(i).getBuyID(), BuyList.get(i).getBuytxTime(),
					BuyList.get(i).getBuyAmt(), currName);

		}
		return output;

	}

}

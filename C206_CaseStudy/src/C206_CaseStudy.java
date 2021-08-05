import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency(702, "SGD", 0.7, 1.3, 10000));
		currencyList.add(new Currency(840, "USD", 1.3, 0.7, 5000));
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
			} else if (option == 9) {
				C206_CaseStudy.searchCurrencyholding(currencyList);
			} else if (option == 10) {
				C206_CaseStudy.searchBuySellrate(currencyList);
			} else if (option == 11) {
				C206_CaseStudy.calculateConvert(currencyList);
			} else if (option == 12) {
				C206_CaseStudy.addTransaction(currencyList);
			} else if (option == 15) {
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

	public static void addCurrency(ArrayList<Currency> currencyList) {
		
	
		C206_CaseStudy.setHeader("Add Currency");
		int iso = Helper.readInt("Enter ISO: ");
		String name = Helper.readString("Enter Name: ");
		Double bRate = Helper.readDouble("Enter Buy Rate: ");
		Double sRate = Helper.readDouble("Enter Sell Rate: ");
		
		for (int i = 0; i < currencyList.size(); i++) {
			currencyList.get(i).setISO(iso);
			currencyList.get(i).setName(name);
			currencyList.get(i).setbRate(bRate);
			currencyList.get(i).setsRate(sRate);
			System.out.println( currencyList.get(i).getName() + " has been added");
			
			}

	}

	public static void viewAllCurrency(ArrayList<Currency> currencyList) {

		C206_CaseStudy.setHeader("Currency LIST");
		String output = String.format("%-10s %-30s %-10.2f %-10.2f\n", "ISO", "NAME",
				 "BUY RATE", "SELL RATE");
		 output += retrieveAllCurrency(currencyList);
		System.out.println(output);
	}

	private static String retrieveAllCurrency(ArrayList<Currency> currencyList) {
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-10s\\n", currencyList.get(i).getISO(), currencyList.get(i).getName(), currencyList.get(i).getbRate(),  currencyList.get(i).getsRate() );
		}
		return output;
	}

	public static void deleteCurrency(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("Delete Currency");
		boolean Ismatch = false;
		int iso = Helper.readInt("Enter Currency ISO: ");
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO() == iso) {
				currencyList.get(i).setISO(0);
				currencyList.get(i).setName(null);
				currencyList.get(i).setbRate(0);
				currencyList.get(i).setsRate(0);
				System.out.println(currencyList.get(i).getName() + " has been deleted");
				Ismatch = true;
			}
		}
		if(!Ismatch) {
			System.out.println("No such ISO");
		}

	}

	public static void addHolding(ArrayList<Currency> currencyList) {

		C206_CaseStudy.setHeader("Add Holding");
		int iso = Helper.readInt("Enter Currency ISO: ");
		boolean match = false;
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO() == iso) {
				double holding = Helper.readDouble("Enter holding amount to add: ");
				currencyList.get(i).setHolding(currencyList.get(i).getHolding() + holding);
				System.out.println(holding + "" + currencyList.get(i).getName() + " has been added");
				match = true;
			}
		}
		if(!match) {
			System.out.println("No such ISO");
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
		int iso = Helper.readInt("Enter Currency ISO: ");
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getISO() == iso) {
				double holding = Helper.readDouble("Enter holding amount to delete: ");
				currencyList.get(i).setHolding(currencyList.get(i).getHolding() - holding);
				System.out.println(holding + "" + currencyList.get(i).getName() + " has been deleted");
				match = true;
			}
		}
		if(!match) {
			System.out.println("No such ISO");
		}

	}

	public static void viewCompanyholding(ArrayList<Currency> currencyList) {

	}

	public static void viewSGDvalue(ArrayList<Currency> currencyList) {

	}

	public static void searchCurrencyholding(ArrayList<Currency> currencyList) {

	}

	 public static void searchBuySellrate(ArrayList<Currency> currencyList) {
	        C206_CaseStudy.setHeader("Search Buy & Sell rate currency");
	        int iso = Helper.readInt("Enter currency ISO> ");
	        String output=String.format("%-15s %-15s %-15s %-15s\n", "CURRENCY ISO", "CURRENCY NAME", "BUY RATE", "SELL RATE");
	        for(int i = 0; i<currencyList.size();i++) {
	            if(currencyList.get(i).getISO() == iso) {
	                output += String.format("%-15d %-15s %-15.2f %-15.2f\n", currencyList.get(i).getISO(), currencyList.get(i).getName(), currencyList.get(i).getbRate(), currencyList.get(i).getsRate());
	            }
	        }System.out.println(output);
	    }

	 

	    public static void calculateConvert(ArrayList<Currency> currencyList) {
	        C206_CaseStudy.setHeader("Currency Converter Calculator");
	        System.out.println("1. SELL Foreign Currency");
	        System.out.println("2. Buy Local Currency");
	        int option = Helper.readInt("Enter option> ");
	        double buyamt = 0.0;
	        double sellamt = 0.0;
	        double convertamt=0.0;
	        String name="";
	        String aName="";
	        String output="";
	        if(option == 1) {
	            int iso = Helper.readInt("Enter currency ISO you want to sell to customer> ");
	            int buyiso = Helper.readInt("Enter currency ISO you want to buy from customer> ");
	            int amount = Helper.readInt("Enter amount of currency you want to exchange> ");
	            for(int i = 0; i<currencyList.size();i++) {
	                if( iso == currencyList.get(i).getISO()) {
	                    buyamt = currencyList.get(i).getbRate();
	                    name = currencyList.get(i).getName();
	                }
	                if(currencyList.get(i).getISO() == buyiso) {
	                    sellamt = currencyList.get(i).getsRate();
	                    aName = currencyList.get(i).getName();
	                }
	                convertamt = (amount * buyamt) * sellamt;
	                output = String.format("Converted amount from %s to %s is $%-1.2f", name, aName, convertamt);
	            }
	            System.out.println(output);
	        }else if(option == 2){
	            int iso = Helper.readInt("Enter currency ISO you want to buy from customer> ");
	            int selliso = Helper.readInt("Enter currency ISO you want to sell to customer> ");
	            int amount = Helper.readInt("Enter amount of currency you want to exchange> ");
	            for(int i = 0; i<currencyList.size();i++) {
	                if( iso == currencyList.get(i).getISO()) {
	                    sellamt = currencyList.get(i).getsRate();
	                    name = currencyList.get(i).getName();
	                }
	                if(currencyList.get(i).getISO() == selliso) {
	                    buyamt = currencyList.get(i).getbRate();
	                    aName = currencyList.get(i).getName();
	                }
	                convertamt = (amount * sellamt) * buyamt;
	                output = String.format("Converted amount from %s to %s is $%-1.2f", name, aName, convertamt);

	 

	            }
	            System.out.println(output);
	        }
	    }

	public static void addTransaction(ArrayList<Currency> currencyList) {

	}

	

}

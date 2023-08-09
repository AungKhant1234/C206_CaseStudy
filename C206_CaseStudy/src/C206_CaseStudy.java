import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();
	private static final int OPTION_PAYMENT = 3;
	private static ArrayList<Order> orderList = new ArrayList<Order>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		paymentMethod.add(new PaymentMethod("Lily", "700300", 3232, "POSB", "MASTER"));
		paymentMethod.add(new PaymentMethod("Johnny", "100200", 5678, "UOB", "CREDIT CARD"));

		orderList.add(new Order("OD25", "Johnny", "87459845", "2"));
		orderList.add(new Order("OD26", "Lily", "85478956", "1"));

		int option = 0;
		while (option != 6) {
			mainMenu();
			option = Helper.readInt("Enter an option to proceed > ");
			System.out.println("");
			if (option == 1) {

			} else if (option == 2) {
				orderOptions();

			} else if (option == OPTION_PAYMENT) {
				paymentMethodOptions();

			} else if (option == 4) {

			} else if (option == 5) {

			} else if (option == 6) {
				System.out.println("THANK YOU FOR USING OUR LUNCH BOX ORDERING SYSTEM");
			}
		}

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void mainMenu() {
		setHeader("SHCOOL LUNCH BOX ONINE ORDERING SYSTEM");
		System.out.println("1. ");
		System.out.println("2. ORDER OPTIONS ");
		System.out.println("3. PAYMENT METHOD OPTIONS");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. QUIT");
		Helper.line(80, "-");

	}

	// Aung --------- A method created to handle everything related to
	// Payment Methods (ADD/ VIEW/ DELETE)
	public static void paymentMethodOptions() {
		int option = 0;
		final int OPTION_ADD = 1;
		final int OPTION_VIEW = 2;
		final int OPTION_DELETE = 3;
		final int OPTION_QUIT = 4;
		while (option != OPTION_QUIT) {
			paymentMenu();
			option = Helper.readInt("Enter an option to proceed > ");
			System.out.println("");

			if (option == OPTION_ADD) {
				PaymentMethod py = inputPaymentMethod();
				addPaymentMethod(paymentMethod, py);
			} else if (option == OPTION_VIEW) {
				viewAllPaymentMethod(paymentMethod);
			} else if (option == OPTION_DELETE) {
				PaymentMethod py = askForDelete(paymentMethod);
				deletePaymentMethod(paymentMethod, py);
			} else if (option == OPTION_QUIT) {
				System.out.println("RETURNING TO MAIN MENU!");
			} else {
				System.out.println("INVALID OPTION. PLEASE CHOOSE AGAIN!\n");
			}
		}

	}

	// Aung --------- Menu Created for Payment Method Options ------
	public static void paymentMenu() {
		setHeader("PAYMENT METHOD OPTIONS");
		System.out.println("1. ADD NEW PAYMENT METHOD");
		System.out.println("2. VIEW ALL PAYMENT METHODS");
		System.out.println("3. DELETE AN EXISTING PAYMENT METHOD");
		System.out.println("4. RETURN TO MAIN MENU");
		Helper.line(80, "-");
	}

	// Aung --------- Ask user to enter their credentials for AddPaymentMethod
	public static PaymentMethod inputPaymentMethod() {
		String cardHolder = Helper.readString("Enter card holder name > ");
		String postalCode = Helper.readString("Enter postal code > ");
		int last4Digit = Helper.readInt("Enter the last 4 digit of the card > ");
		String bankName = Helper.readString("Enter bank name > ").toUpperCase();
		String cardType = Helper.readString("Enter card type > ").toUpperCase();
		Helper.line(80, "-");
		PaymentMethod py = new PaymentMethod(cardHolder, postalCode, last4Digit, bankName, cardType);

		return py;
	}

	// Aung -------------------- Add new Payment Method to paymentMethod List
	public static void addPaymentMethod(ArrayList<PaymentMethod> paymentMethodList, PaymentMethod py) {
		int last4Digit = py.getLast4Digit();
		String cardHolder = py.getCardHolder();
		String bankName = py.getBankName();
		String cardType = py.getCardType();
		String postalCode = py.getPostalCode();
		for (PaymentMethod payment : paymentMethodList) {
			if (payment.getLast4Digit() == last4Digit) {
				System.out.println("This payment method already exists in the system.\n");
				return;
			}
		}
		if (cardHolder.isEmpty() || bankName.isEmpty() || cardType.isEmpty() || postalCode.isEmpty()
				|| (last4Digit == 0)) {
			System.out.println("There are missing informations.\nPlease make sure to fill out everything!\n");
			return;
		}
		paymentMethodList.add(py);
		System.out.println("PAYMENT METHOD SUCCESSFULLY ADDED!\n");
	}

	// Aung --------- Retrieve all Payment Method objects from paymentMethod List
	public static String retrieveAllPaymentMethod(ArrayList<PaymentMethod> paymentMethod) {
		String output = "";
		// write your code here
		for (PaymentMethod p : paymentMethod) {
			output += String.format("%-15s %-15s %-15d %-15s %-15s\n", p.getCardHolder(), p.getPostalCode(),
					p.getLast4Digit(), p.getBankName(), p.getCardType());
		}
		return output;

	}

	// Aung -------------------- Display all Payment Methods to the user
	public static void viewAllPaymentMethod(ArrayList<PaymentMethod> paymentMethod) {
		C206_CaseStudy.setHeader("PAYMENT METHOD LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-15s\n", "CARD HOLDER", "POSTAL CODE", "LAST 4 DIGIT",
				"BANK NAME", "CARD TYPE");
		output += retrieveAllPaymentMethod(paymentMethod);
		System.out.println(output);
	}

	// Aung -------------------- Delete Payment Method from paymentMethod List
	public static PaymentMethod askForDelete(ArrayList<PaymentMethod> paymentMethod) {
		int last4Digit = Helper.readInt("Enter last 4 digit of the card you want to delete > ");
		for (PaymentMethod p : paymentMethod) {
			if (p.getLast4Digit() == last4Digit) {
				return p;
			}
		}
		return null;
	}

	// Aung -------------------- Delete Payment Method from paymentMethod List
	public static void deletePaymentMethod(ArrayList<PaymentMethod> paymentMethod, PaymentMethod py) {
		if (py != null) {
			for (PaymentMethod p : paymentMethod) {
				int last4Digit = py.getLast4Digit();
				if (p.getLast4Digit() == last4Digit) {
					paymentMethod.remove(p);
					System.out.println("PAYMENT METHOD SUCCESSFULLY DELETED!\n");
					return;
				}
			}
		}
		System.out.println("This payment method doesn't exist in the system!\n");

	}

	// XUENI --------- A method created to handle everything related to
	// Orders (ADD/ VIEW/ DELETE)
	public static void orderOptions() {
		int option = 0;
		while (option != 4) {
			orderMenu();
			option = Helper.readInt("Enter an option to proceed > ");
			System.out.println("");

			if (option == 1) {
				Order od = inputOrder();
				addNewOrder(orderList, od);

			} else if (option == 2) {
				viewAllOrders(orderList);

			} else if (option == 3) {
				deleteOrder(orderList);

			} else if (option == 4) {
				System.out.println("RETURNING TO MAIN MENU");
			} else {
				System.out.println("INVALID OPTION. PLEASE CHOOSE AGAIN!\n");
			}
		}
	}

	// XUENI --------- Menu Created for Payment Method Options ------
	public static void orderMenu() {
		setHeader("OPTIONS FOR ORDER");
		System.out.println("1. ADD A NEW ORDER ");
		System.out.println("2. VIEW ALL ORDERS ");
		System.out.println("3. DELETE AN EXISTING ORDERS ");
		System.out.println("4. RETURN TO MAIN MENU");
		Helper.line(80, "-");
	}

	// XUENI-------------------RETRIEVE ALL ORDER LIST FROM orderList IN ORDER TO
	// VIEW IT-----------------------------------
	public static String retrieveAllOrders(ArrayList<Order> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-10s %-20s %-20s %-10s\n", orderList.get(i).getOrderId(),
					orderList.get(i).getCustomerName(), orderList.get(i).getMobileNumber(),
					orderList.get(i).getquantity());
		}
		return output;
	}

	// XUENI-----------------------VIEW ALL ORDER FROM THE
	// ORDERLIST----------------------------------------
	public static void viewAllOrders(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-10s %-20s %-20s %-10s\n", "ORDER ID", "CUSTOMER NAME", "MOBILE NUMBER",
				"QUANTITY");
		output += retrieveAllOrders(orderList);
		System.out.println(output);
	}

	// XUENI----------------------ADD AN ORDER TO THE
	// ORDERLIST--------------------------------------------------
	public static Order inputOrder() {
		String OrderID = Helper.readString("Enter Order ID > ");
		String customerName = Helper.readString("Enter Customer Name > ");
		String mobileNo = Helper.readString("Enter Mobile Number > ");
		String quantity = Helper.readString("Enter the Quantity > ");

		Order OD = new Order(OrderID, customerName, mobileNo, quantity);
		return OD;

	}

	public static void addNewOrder(ArrayList<Order> orderList, Order OD) {
		Order item;
		for (int i = 0; i < orderList.size(); i++) {
			item = orderList.get(i);
			if (item.getOrderId().equalsIgnoreCase(OD.getOrderId()))
				return;
		}
		if ((OD.getOrderId().isEmpty()) || (OD.getCustomerName().isEmpty())) {
			return;
		}

		orderList.add(OD);
		System.out.println("ORDER ADDED SUCCESSFULLY!");
	}

	// XUENI------------------------DELETE AN EXSITING ORDER FROM
	// ORDERLIST---------------------------------
	public static boolean inputOrderID(ArrayList<Order> orderList, String OrderID) {
		boolean isDeleted = false;

		for (int i = 0; i < orderList.size(); i++) {
			if (OrderID.equalsIgnoreCase(orderList.get(i).getOrderId())) {
				orderList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.viewAllOrders(orderList);
		String OrderID = Helper.readString("Enter the Order ID you wish to delete > ");
		Boolean isDeleted = inputOrderID(orderList, OrderID);

		if (isDeleted == false) {
			System.out.println("No Order ID found.");

		} else {
			System.out.println("Order ID " + OrderID + " removed successfully!");
		}
	}

}

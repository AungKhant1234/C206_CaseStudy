import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_ORDER = 2;
	private static final int OPTION_MENU = 5;
	private static final int OPTION_USER = 1;
	private static ArrayList<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();
	private static final int OPTION_PAYMENT = 3;
	private static final int OPTION_VENDOR = 4;
	private static ArrayList<Order> orderList = new ArrayList<Order>();

	private static ArrayList<User> UserList = new ArrayList<User>();
	private static ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
	
	private static ArrayList<Menu> menuList = new ArrayList<Menu>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		paymentMethod.add(new PaymentMethod("Lily", "700300", 3232, "POSB", "MASTER"));
		paymentMethod.add(new PaymentMethod("Johnny", "100200", 5678, "UOB", "CREDIT CARD"));

		orderList.add(new Order("OD25", "Johnny", "87459845", "2"));
		orderList.add(new Order("OD26", "Lily", "85478956", "1"));

		UserList.add(new User("760001", "Johnny", "87459845", "Johnny123@gmail.com"));
		UserList.add(new User("760002", "Lily", "85478956", "Lily123@gmail.com"));

		vendorList.add(new Vendor("100101", "BB companies", "83150820", "bbcompanies@gmail.com"));
		vendorList.add(new Vendor("100102", "KK comp", "83723573","kkcomsg@gmail.com"));
		
		menuList.add(new Menu("Italian", "Zuppe e salse(soups and sauces), Pane(bread), Pizzas, Pastas, Rice dishes, Carne(meat dishes and cured meats), Deserts and Pastries, Drinks", 7.99, 00001));
		menuList.add(new Menu("Indian", "South Indian(dosa, idlis, vadas, Kerala Parotta), North Indian(chappathi, paneer, chicken 65, chicken tikka, aloo, dhal), Deserts and Pastries, Drinks", 5.99, 00002));

		int option = 0;
		while (option != 6) {
			mainMenu();
			option = Helper.readInt("Enter an option to proceed > ");
			System.out.println("");
			if (option == OPTION_USER) {
				UserOptions();
			} else if (option == OPTION_ORDER) {
				orderOptions();

			} else if (option == OPTION_PAYMENT) {
				paymentMethodOptions();

			} else if (option == OPTION_VENDOR) {
				vendorOptions();
				
			} else if (option == OPTION_MENU) {
				menuOptions();

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
		System.out.println("1. USERS OPTIONS");
		System.out.println("2. ORDER OPTIONS ");
		System.out.println("3. PAYMENT METHOD OPTIONS");
		System.out.println("4. VENDOR OPTIONS");
		System.out.println("5. MENU OPTIONS");
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

	// Aung ------------ Ask user for the payment method to delete
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

	// XUENI --------- Menu Created for Order Options ------
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

	// EUGENE --------- A method created to handle everything related to
	// Users (ADD/ VIEW/ DELETE)
	public static void UserOptions() {
		int option = 0;
		final int OPTION_QUIT = 4;
		final int OPTION_DELETE = 3;
		final int OPTION_VIEW = 2;
		final int OPTION_ADD = 1;
		while (option != 4) {
			UserMenu();
			option = Helper.readInt("Enter an option to proceed > ");
			System.out.println("");

			if (option == OPTION_ADD) {
				User UM  = InputUsersMethod();
				addUserMethod(UserList,UM);
			} else if (option == OPTION_VIEW) {
				viewAllUsers(UserList);
			} else if (option == OPTION_DELETE) {
				inputUserID(UserList);
			} else if (option == OPTION_QUIT) {
				System.out.println("RETURNING TO MAIN MENU!");
			} else {
				System.out.println("INVALID OPTION. PLEASE CHOOSE AGAIN!\n");
			}
		}
	}

	// EUGENE --------- Menu Created for User Method Options ------
	public static void UserMenu() {
		setHeader("OPTIONS FOR USERS");
		System.out.println("1. ADD A NEW USER ");
		System.out.println("2. VIEW ALL USERS ");
		System.out.println("3. DELETE AN EXISTING USER/USERS ");
		System.out.println("4. RETURN TO MAIN MENU");
		Helper.line(80, "-");
	}

	// EUGENE --------- Ask user to enter their credentials for AddUsersMethod
	public static User InputUsersMethod() {
		String userid = Helper.readString("Enter ID > ");
		String username = Helper.readString("Enter Username > ");
		String mobilenum = Helper.readString("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		Helper.line(80, "-");
		User UM = new User(userid, username, mobilenum, email);

		return UM;
	}

	// EUGENE -------------------- Add new User Method to UserList
	public static void addUserMethod(ArrayList<User> UserList, User UM) {
		String mobilenum = UM.getMobileNumber();
		String userid = UM.getUserId();
		String username = UM.getUserName();
		String email = UM.getemail();
		for (User Users : UserList) {
			if (Users.getUserId() == userid) {
				System.out.println("This User already exists in the system.\n");
				return;
			}
		}
		if (mobilenum.isEmpty() || username.isEmpty() || email.isEmpty() || userid.isEmpty()) {
			System.out.println("There are missing informations.\nPlease make sure to fill out everything!\n");
			return;
		}
		UserList.add(UM);
		System.out.println("USER SUCCESSFULLY ADDED!\n");

	}

	// EUGENE-------------------RETRIEVE ALL USER LIST FROM UserList IN ORDER TO
	// VIEW IT-----------------------------------
	public static String retrieveAllUsers(ArrayList<User> UserList) {
		String output = "";

		for (int i = 0; i < UserList.size(); i++) {
			output += String.format("%-10s %-20s %-20s %-10s\n", UserList.get(i).getUserId(),
					UserList.get(i).getUserName(), UserList.get(i).getMobileNumber(), UserList.get(i).getemail());
		}
		return output;
	}

	// EUGENE-----------------------VIEW ALL USER FROM THE
	// USERLIST----------------------------------------
	public static void viewAllUsers(ArrayList<User> UserList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-20s %-20s %-10s\n", "USER ID", "USER NAME", "MOBILE NUMBER", "EMAIL");
		output += retrieveAllUsers(UserList);
		System.out.println(output);
	}
	
	


	// EUGENE------------------------DELETE AN EXSITING ORDER FROM
	// USERLIST---------------------------------

	public static boolean delUserID(ArrayList<User> UserList, String UserId) {
		boolean isDeleted = false;

		for (int i = 0; i < UserList.size(); i++) {
			if (UserId.equalsIgnoreCase(UserList.get(i).getUserId())) {
				UserList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void inputUserID(ArrayList<User> UserList) {
		C206_CaseStudy.viewAllUsers(UserList);
		String UserID = Helper.readString("Enter the User ID you wish to delete > ");
		Boolean isDeleted = delUserID(UserList, UserID);

		
		if (isDeleted == false) {
			System.out.println("No user ID found.");

		} else {
			System.out.println("User ID " + UserID + " removed successfully!");
		}
	}

	// TOMIN ------ A method created to handle everything related to 
	// Vendors (ADD/VIEW/DELETE)
	public static void vendorOptions() {
		int option = 0;
		final int OPTION_QUIT = 4;
		final int OPTION_DELETE = 3;
		final int OPTION_VIEW = 2;
		final int OPTION_ADD = 1;
		while (option != 4) {
			vendorMenu();
			option = Helper.readInt("Enter an option to proceed > ");
			System.out.println("");

			if (option == OPTION_ADD) {
				Vendor vn  = InputVendor();
				addVendorMethod(vendorList,vn);
			} else if (option == OPTION_VIEW) {
				viewAllVendors(vendorList);
			} else if (option == OPTION_DELETE) {
				deleteVendor(vendorList);
			} else if (option == OPTION_QUIT) {
				System.out.println("RETURNING TO MAIN MENU!");
			} else {
				System.out.println("INVALID OPTION. PLEASE CHOOSE AGAIN!\n");
			}
		}
	}
	// TOMIN --------- Menu Created for Vendor Options ------
		public static void vendorMenu() {
			setHeader("OPTIONS FOR VENDOR");
			System.out.println("1. ADD A NEW VENDOR ");
			System.out.println("2. VIEW ALL VENDORS ");
			System.out.println("3. DELETE AN EXISTING VENDOR ");
			System.out.println("4. RETURN TO MAIN MENU");
			Helper.line(80, "-");
		}
		
		// TOMIN-------------------RETRIEVE ALL VENDORS FROM VendorList IN ORDER TO
		// VIEW IT-----------------------------------
		public static String retrieveAllvendors(ArrayList<Vendor> vendorList) {
			String output = "";

			for (int i = 0; i < vendorList.size(); i++) {
				output += String.format("%-10s %-20s %-20s %-10s\n", vendorList.get(i).getVendorId(),
						vendorList.get(i).getvendorName(), vendorList.get(i).getMobileNumber(), vendorList.get(i).getEmail());
			}
			return output;
		}
		// TOMIN --------- Ask admin to enter their credentials for AddVendorMethod
		public static Vendor InputVendor() {
			String VendorId = Helper.readString("Enter ID > ");
			String vendorName = Helper.readString("Enter Vendorname > ");
			String mobilenum = Helper.readString("Enter mobile number > ");
			String email = Helper.readString("Enter email > ");
			Helper.line(80, "-");
			Vendor vn = new Vendor(VendorId, vendorName, mobilenum, email);

			return vn;
		}

		// TOMIN -------------------- Add new Vendor Method to VendorList
		public static void addVendorMethod(ArrayList<Vendor> vendorList, Vendor vn) {
			String mobilenum = vn.getMobileNumber();
			String VendorId = vn.getVendorId();
			String vendorName = vn.getvendorName();
			String email = vn.getEmail();
			for (Vendor Vendors : vendorList) {
				if (Vendors.getVendorId() == VendorId) {
					System.out.println("This Vendor already exists in the system.\n");
					return;
				}
			}
			if (mobilenum.isEmpty() || vendorName.isEmpty() || email.isEmpty() || VendorId.isEmpty()) {
				System.out.println("There are missing informations.\nPlease make sure to fill out everything!\n");
				return;
			}
			vendorList.add(vn);
			System.out.println("USER SUCCESSFULLY ADDED!\n");

		}
		// TOMIN-----------------------VIEW ALL VENDOR FROM THE
		// VENDORLIST----------------------------------------
		public static void viewAllVendors(ArrayList<Vendor> vendorList) {
			C206_CaseStudy.setHeader("VENDOR LIST");
			String output = String.format("%-10s %-20s %-20s %-10s\n", "VENDOR ID", "VENDOR NAME", "MOBILE NUMBER", "EMAIL");
			output += retrieveAllvendors(vendorList);
			System.out.println(output);
		}

		// TOMIN------------------------DELETE AN EXSITING VENDOR FROM
		// LIST---------------------------------
		public static boolean inputVendorId(ArrayList<Vendor> vendorList, String VendorId) {
			boolean isDeleted = false;

			for (int i = 0; i < vendorList.size(); i++) {
				if (VendorId.equalsIgnoreCase(vendorList.get(i).getVendorId())) {
					vendorList.remove(i);
					isDeleted = true;
				}
			}
			return isDeleted;
		}

		public static void deleteVendor(ArrayList<Vendor> vendorList) {
			C206_CaseStudy.viewAllVendors(vendorList);
			String VendorId = Helper.readString("Enter the Vendor ID you wish to delete > ");
			Boolean isDeleted = inputVendorId(vendorList, VendorId);

			if (isDeleted == false) {
				System.out.println("No vendor ID found.");

			} else {
				System.out.println("Vendor ID " + VendorId + " removed successfully!");
			}
		}

		// KELVIN --------- A method created to handle everything related to
		// Menu (ADD/ VIEW/ DELETE)
		public static void menuOptions() {
			int option = 0;
			final int OPTION_QUIT = 4;
			final int OPTION_DELETE = 3;
			final int OPTION_VIEW = 2;
			final int OPTION_ADD = 1;
			while (option != 4) {
				MenusMenu();
				option = Helper.readInt("Enter an Option to Proceed > ");
				System.out.println("");

				if (option == OPTION_ADD) {
					Menu MN  = InputMenuMethod();
					addMenuMethod(menuList,MN);
				} else if (option == OPTION_VIEW) {
					viewAllMenus(menuList);
				} else if (option == OPTION_DELETE) {
					deleteMenuID(menuList);
				} else if (option == OPTION_QUIT) {
					System.out.println("RETURNING TO MAIN MENU!");
				} else {
					System.out.println("INVALID OPTION. PLEASE CHOOSE AGAIN!\n");
				}
			}
		}
		// KELVIN --------- Menu Created for Menus Method Options ------
		public static void MenusMenu() {
			setHeader("OPTIONS FOR MENUS");
			System.out.println("1. ADD A NEW MENUS ");
			System.out.println("2. VIEW ALL MENUS ");
			System.out.println("3. DELETE AN EXISTING MENU/MENUS ");
			System.out.println("4. RETURN TO MAIN MENU");
			Helper.line(80, "-");
		}

		// KELVIN --------- Ask user to enter Menu for AddUsersMethod
		public static Menu InputMenuMethod() {
			String name = Helper.readString("Enter Menu Name > ");
			String description = Helper.readString("Enter Menu Description > ");
			double price = Helper.readDouble("Enter Menu Starting Price (cheapest item on the menu) > ");
			int id = Helper.readInt("Enter Menu Id > ");
			Helper.line(80, "-");
			Menu MN = new Menu(name, description, price, id);

			return MN;
		}

		// KELVIN -------------------- Add new User Method to UserList
		public static void addMenuMethod(ArrayList<Menu> menuList, Menu MN) {
			String name = MN.getName();
			String description = MN.getDescription();
			double price = MN.getPrice();
			int id = MN.getId();
			for (Menu Menus : menuList) {
				if (id == Menus.getId()) {
					System.out.println("This Menu already exists in the system.\n");
					return;
				}
			}
			if (name.isEmpty() || description.isEmpty() || Double.toString(price).isEmpty() || Integer.toString(id).isEmpty()) {
				System.out.println("There are missing information.\nPlease fill out all the information!\n");
				return;
			}
			menuList.add(MN);
			System.out.println("MENU SUCCESSFULLY ADDED!\n");

		}

		// KELVIN -------------------RETRIEVE ALL USER LIST FROM UserList IN ORDER TO
		// VIEW IT-----------------------------------
		public static String viewAllMenu(ArrayList<Menu> menuList) {
			String output = "";

			for (int i = 0; i < menuList.size(); i++) {
				output += String.format("%-10s %-20s %-20s %-10s\n", menuList.get(i).getId(),
						menuList.get(i).getName(), menuList.get(i).getPrice(), menuList.get(i).getDescription());
			}
			return output;
		}

		// KELVIN -----------------------VIEW ALL USER FROM THE
		// USERLIST----------------------------------------
		public static void viewAllMenus(ArrayList<Menu> menuList) {
			C206_CaseStudy.setHeader("USER LIST");
			String output = String.format("%-10s %-20s %-20s %-10s\n", "MENU ID", "MENU NAME", "STARTING PRICE", "DESCRIPTION");
			output += viewAllMenu(menuList);
			System.out.println(output);
		}
		
		


		// KELVIN ------------------------DELETE AN EXSITING ORDER FROM
		// USERLIST---------------------------------

		public static boolean delMenuID(ArrayList<Menu> menuList, String Id) {
			boolean isDeleted = false;

			for (int i = 0; i < menuList.size(); i++) {
				if (Id.equalsIgnoreCase(Integer.toString(menuList.get(i).getId()))) {
					menuList.remove(i);
					isDeleted = true;
				}
			}
			return isDeleted;
		}

		public static void deleteMenuID(ArrayList<Menu> menuList) {
			C206_CaseStudy.viewAllMenu(menuList);
			String umenuId = Helper.readString("Enter The Menu ID You Wish To Delete > ");
			Boolean isDeleted = delMenuID(menuList, umenuId);

			
			if (isDeleted == false) {
				System.out.println("No Menu ID found.");

			} else {
				System.out.println("Menu ID " + umenuId + " removed successfully!");
			}
		}
}

import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private ArrayList<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();
	private PaymentMethod py1;
	private PaymentMethod py2;

	private Order order1;
	private Order order2;
	private ArrayList<Order> orderList;

	private ArrayList<User> UserList;
	private User user1;
	private User user2;
	
	private ArrayList <Vendor> vendorList = new ArrayList<Vendor>();
	private Vendor vendor1;
	private Vendor vendor2;

	private ArrayList<Menu> menuList;
	private Menu menu1;
	private Menu menu2;
	@Before
	public void setUp() throws Exception {
		py1 = new PaymentMethod("John", "111222", 1234, "OCBC", "VISA");
		py2 = new PaymentMethod("Marry", "222111", 4321, "DBS", "NETS");

		order1 = new Order("OD25", "Johnny", "87459845", "2", "Pizzas");
		order2 = new Order("OD26", "Lily", "85478956", "1", "Drinks");
		orderList = new ArrayList<Order>();

		UserList = new ArrayList<User>();
		user1 = new User("760001", "Johnny", "87459845", "Johnny123@gmail.com");
		user2 = new User("760002", "Lily", "85478956", "Lily123@gmail.com");

		vendor1 = new Vendor("100101", "BB companies", "83150820", "bbcompanies@gmail.com");
		vendor2 = new Vendor("100102", "KK comp", "83723573","kkcomsg@gmail.com");
		
		menuList = new ArrayList<Menu>();
		menu1 = new Menu("Italian", "Zuppe e salse(soups and sauces), Pane(bread), Drinks", 7.99, 1);
		menu2 = new Menu("Indian", "South Indian(dosa, Kerala Parotta), North Indian(chappathi, dhal), Drinks", 5.99, 2);

	}

	// Aung
	@Test
	public void testAddPaymentMethod() {
		// Item list is not null, so that can add a new payment method - boundary
		assertNotNull("Check if there is valid PaymentInfo arraylist to add to", paymentMethod);
		// Given an empty list, after adding 1 payment method, the size of the list is 1
		// - normal
		// The payment method just added is as same as the first item of the list
		C206_CaseStudy.addPaymentMethod(paymentMethod, py1);
		assertEquals("Check that PaymentInfo arraylist size is 1", 1, paymentMethod.size());
		assertSame("Check that PaymentInfo is added", py1, paymentMethod.get(0));

		// Add another payment method. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addPaymentMethod(paymentMethod, py2);
		assertEquals("Check that PaymentInfo arraylist size is 2", 2, paymentMethod.size());
		assertSame("Check that PaymentInfo is added", py2, paymentMethod.get(1));

		// Add a payment method with missing information.
		// Test that the size of the list is unchanged. - error
		PaymentMethod py3 = new PaymentMethod("Elle", "", 9876, "DBS", "VISA");
		C206_CaseStudy.addPaymentMethod(paymentMethod, py3);
		assertEquals("Check that PaymentInfo arraylist size is 2", 2, paymentMethod.size());

		// Add a payment method which is with same card holder. ( 1 user can have
		// multiple payment methods )
		// The payment method is added and the size of the list changed. - normal

		PaymentMethod py4 = new PaymentMethod("John", "111222", 9875, "DBS", "MASTER");
		C206_CaseStudy.addPaymentMethod(paymentMethod, py4);
		assertEquals("Check that PaymentInfo arraylist size is 3", 3, paymentMethod.size());

		// Add a payment method that already exists in the list.
		// Test that the size of the list remains the same. - error
		C206_CaseStudy.addPaymentMethod(paymentMethod, py1);
		assertEquals("Check that PaymentInfo arraylist size is 3", 3, paymentMethod.size());

	}

	// Aung
	@Test
	public void testRetrieveAllPaymentMethod() {
		// fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid PaymentInfo arraylist to retrieve item from", paymentMethod);

		// test if the list of PaymentInfo retrieved from the SourceCentre is empty -
		// boundary
		String allPaymentMethod = C206_CaseStudy.retrieveAllPaymentMethod(paymentMethod);
		String testOutput = "";
		assertEquals("Test that the retrieved PaymentMethod list is empty?", testOutput, allPaymentMethod);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addPaymentMethod(paymentMethod, py1);
		C206_CaseStudy.addPaymentMethod(paymentMethod, py2);
		assertEquals("Test that PaymentMethod arraylist size is 2", 2, paymentMethod.size());

		// test if the expected output string is the same as the list of Payment Methods
		// retrieved from the SourceCentre - normal
		allPaymentMethod = C206_CaseStudy.retrieveAllPaymentMethod(paymentMethod);
		testOutput = String.format("%-15s %-15s %-15d %-15s %-15s\n", "John", "111222", 1234, "OCBC", "VISA");
		testOutput += String.format("%-15s %-15s %-15d %-15s %-15s\n", "Marry", "222111", 4321, "DBS", "NETS");
		assertEquals("Test that ViewAllPaymentMethod", testOutput, allPaymentMethod);
	}

	// Aung
	@Test
	public void testDeletePaymentMethod() {
		PaymentMethod py3 = new PaymentMethod("Elle", "600800", 9876, "DBS", "VISA");

		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid PaymentInfo arraylist to delete item from", paymentMethod);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addPaymentMethod(paymentMethod, py1);
		C206_CaseStudy.addPaymentMethod(paymentMethod, py2);
		assertEquals("Test that PaymentMethod arraylist size is 2", 2, paymentMethod.size());

		// Given a list with 2 items, test if the size of the list becomes 1 after
		// deleting one - normal
		C206_CaseStudy.deletePaymentMethod(paymentMethod, py2);
		assertEquals("Test that PaymentMethod arraylist size is 1", 1, paymentMethod.size());

		// Test that the remaining payment method is the one that wasn't deleted - normal
		assertSame("Test that the remaining PaymentMethod is the correct one", py1, paymentMethod.get(0));

		// Given a payment method which isn't in the list,
		// Test that the size of the list doesn't change and remain the same. - error
		C206_CaseStudy.deletePaymentMethod(paymentMethod, py3);
		assertEquals("Test that the size of the list remain the same (1)", 1, paymentMethod.size());

	}

	// XUE NI
	@Test
	public void c206_testAddOrder() {
		// fail("Not yet implemented");
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addNewOrder(orderList, order1);
		assertEquals("Test that the Order arraylist size is 1.", 1, orderList.size());

		// Add an item
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertEquals("Test that the order arraylist size is now 2.", 2, orderList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that Order is added to the end of the list.", order2, orderList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());

		// Add an item that has missing detail to check that it does not add into the arraylist successfully
		Order od_missing = new Order("OD29", "", "96514485", "2","Pasta");
		C206_CaseStudy.addNewOrder(orderList, od_missing);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());

	}

	// XUE NI
	@Test
	public void c206_testRetrieveAllOrders() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());

		// Attempt to retrieve the Order
		String allOrder = C206_CaseStudy.retrieveAllOrders(orderList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allOrder);

		C206_CaseStudy.addNewOrder(orderList, order1);
		C206_CaseStudy.addNewOrder(orderList, order2);

		// Test that the list is not empty
		assertEquals("Test that Order arraylist size is 2.", 2, orderList.size());

		// Attempt to retrieve the Order
		allOrder = C206_CaseStudy.retrieveAllOrders(orderList);
		testOutput = String.format("%-10s %-20s %-20s %-10s %-15s\n", "OD25", "Johnny", "87459845", "2", "Pizzas");
		testOutput += String.format("%-10s %-20s %-20s %-10s %-15s\n", "OD26", "Lily", "85478956", "1", "Drinks");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allOrder);

		// assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	// XUE NI
	@Test
	public void c206_testDeleteOrder() {
		// Test if the Order list is not null and empty
		assertNotNull("Test if there is valid Order arraylist to retrieve order from", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());

		// Test that the list is not empty before deleting
		C206_CaseStudy.addNewOrder(orderList, order1);
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertEquals("Test that Order arraylist size is 2.", 2, orderList.size());

		// The size of the list decreases by one after deleting one order
		C206_CaseStudy.inputOrderID(orderList, "OD25");
		assertEquals("Test that Order arraylist size is 1", 1, orderList.size());

		// Test the order not in the list is not deleted, the size of the list remains
		// the same
		C206_CaseStudy.inputOrderID(orderList, "OD99");
		assertEquals("Test that the size of the list remain the same which is 1", 1, orderList.size());

	}

	// EUGENE
	@Test
	public void c206_testAddUserMethod() {
		// fail("Not yet implemented");
		assertNotNull("Test if there is valid User arraylist to add to", UserList);
		assertEquals("Test that the User arraylist is empty.", 0, UserList.size());
		// Given an empty list, after adding 1 user, the size of the list becomes 1
		C206_CaseStudy.addUserMethod(UserList, user1);
		assertEquals("Test that the User arraylist size is 1.", 1, UserList.size());

		// Add an item
		C206_CaseStudy.addUserMethod(UserList, user2);
		assertEquals("Test that the User arraylist size is now 2.", 2, UserList.size());
		// The user just added is the same as the last item in the list
		assertSame("Test that User is added to the end of the list.", user2, UserList.get(1));

		// Add a user that already exists in the list
		C206_CaseStudy.addUserMethod(UserList, user2);
		assertEquals("Test that the user arraylist size is unchange.", 2, UserList.size());

		//Add a user that has missing detail to check that it does not add into the arraylist successfully
		User user_missing = new User("760001", "Johnny", "87459845", "");
		C206_CaseStudy.addUserMethod(UserList, user_missing);
		assertEquals("Test that the User arraylist size is unchange.", 2, UserList.size());

	}

	// EUGENE
	@Test
	public void c206_testDeleteUser() {
		// Test if the user list is not null and empty
		assertNotNull("Test if there is valid User arraylist to retrieve user from", UserList);
		assertEquals("Test that the User arraylist is empty.", 0, UserList.size());

		// Test that the list is not empty before deleting
		C206_CaseStudy.addUserMethod(UserList, user1);
		C206_CaseStudy.addUserMethod(UserList, user2);
		assertEquals("Test that User arraylist size is 2.", 2, UserList.size());

		// The size of the list decreases by one after deleting one order
		C206_CaseStudy.delUserID(UserList, "760001");
		assertEquals("Test that User arraylist size is 1", 1, UserList.size());

		// Test the user not in the list is not deleted, the size of the list remains
		// the same
		C206_CaseStudy.delUserID(UserList, "76012");
		assertEquals("Test that the size of the list remain the same which is 1", 1, UserList.size());


	}

	// EUGENE
	@Test
	public void c206_testretrieveAllUsers() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Users arraylist to add to", UserList);
		assertEquals("Test that the User arraylist is empty.", 0, UserList.size());

		// Attempt to retrieve the User
		String allUser = C206_CaseStudy.retrieveAllUsers(UserList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);

		C206_CaseStudy.addUserMethod(UserList, user1);
		C206_CaseStudy.addUserMethod(UserList, user2);

		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, UserList.size());

		// Attempt to retrieve the Users
		allUser = C206_CaseStudy.retrieveAllUsers(UserList);
		testOutput = String.format("%-10s %-20s %-20s %-10s\n", "760001", "Johnny", "87459845", "Johnny123@gmail.com");
		testOutput += String.format("%-10s %-20s %-20s %-10s\n", "760002", "Lily", "85478956", "Lily123@gmail.com");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

		// assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	

	// Tomin
		@Test
		public void c206_testAddVendorMethod() {
			// fail("Not yet implemented");
			assertNotNull("Test if there is valid Vendor arraylist to add to", vendorList);
			assertEquals("Test that the Vendor arraylist is empty.", 0, vendorList.size());
			// Given an empty list, after adding 1 vendor, the size of the list becomes 1
			C206_CaseStudy.addVendorMethod(vendorList, vendor1);
			assertEquals("Test that the Vendor arraylist size is 1.", 1, vendorList.size());

			// Add an item
			C206_CaseStudy.addVendorMethod(vendorList, vendor2);
			assertEquals("Test that the Vendor arraylist size is now 2.", 2, vendorList.size());
			// The vendor just added is the same as the last item in the list
			assertSame("Test that Vendor is added to the end of the list.", vendor2, vendorList.get(1));

			// Add a vendor that already exists in the list
			C206_CaseStudy.addVendorMethod(vendorList, vendor2);
			assertEquals("Test that the Vendor arraylist size is unchange.", 2, vendorList.size());

			//Add a vendor that has missing detail to check that it does not add into the arraylist successfully
			Vendor vendor2 = new Vendor("100010", "chenway catering", "", "chenwaysg@gmail.com");
			C206_CaseStudy.addVendorMethod(vendorList,vendor2);
			assertEquals("Test that the Vendor arraylist size is unchange.", 2, vendorList.size());

		}
		// TOMIN
		@Test
		public void c206_testretrieveAllVendors() {
			// Test Case 1
			// Test if Item list is not null and empty
			assertNotNull("Test if there is valid Vendors arraylist to add to", vendorList);
			assertEquals("Test that the Vendor arraylist is empty.", 0, vendorList.size());

			// Attempt to retrieve the Vendor
			String allVendor = C206_CaseStudy.retrieveAllvendors(vendorList);
			String testOutput = "";

			// Test if the output is empty
			assertEquals("Test that nothing is displayed", testOutput, allVendor);

			C206_CaseStudy.addVendorMethod(vendorList, vendor1);
			C206_CaseStudy.addVendorMethod(vendorList, vendor2);

			// Test that the list is not empty
			assertEquals("Test that Vendor arraylist size is 2.", 2, vendorList.size());

			// Attempt to retrieve the Vendor
			allVendor = C206_CaseStudy.retrieveAllvendors(vendorList);
			testOutput = String.format("%-10s %-20s %-20s %-10s\n", "100101", "BB companies", "83150820", "bbcompanies@gmail.com");
			testOutput += String.format("%-10s %-20s %-20s %-10s\n", "100102", "KK comp", "83723573","kkcomsg@gmail.com");

			// Test that the details are displayed correctly
			assertEquals("Test that the display is correct.", testOutput, allVendor);

			// assertTrue("C206_CaseStudy_SampleTest ",true);
		}
		
		// TOMIN
		@Test
		public void c206_testDeleteVendor() {
			// Test if the Vendor list is not null and empty
			assertNotNull("Test if there is valid Vendor arraylist to retrieve vendor from", vendorList);
			assertEquals("Test that the Vendor arraylist is empty.", 0, vendorList.size());

			// Test that the list is not empty before deleting
			C206_CaseStudy.addVendorMethod(vendorList, vendor1);
			C206_CaseStudy.addVendorMethod(vendorList, vendor2);
			assertEquals("Test that vendor arraylist size is 2.", 2, vendorList.size());

			// The size of the list decreases by one after deleting one Vendor
			C206_CaseStudy.inputVendorId(vendorList, "100101");
			assertEquals("Test that Vendor arraylist size is 1", 1, vendorList.size());

			// Test the vendor not in the list is not deleted, the size of the list remains
			// the same
			C206_CaseStudy.inputVendorId(vendorList, "12002");
			assertEquals("Test that the size of the list remain the same which is 1", 1, vendorList.size());


		}
		// KELVIN
	@Test
	public void c206_testAddMenuMethod() {
		// fail("Not yet implemented");
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());
		// Given an empty list, after adding 1 menu, the size of the list becomes 1 - normal
		C206_CaseStudy.addMenuMethod(menuList, menu1);
		assertEquals("Test that the Menu arraylist size is 1.", 1, menuList.size());

		// Add an menu
		C206_CaseStudy.addMenuMethod(menuList, menu2);
		assertEquals("Test that the Menu arraylist size is now 2.", 2, menuList.size());
		// The menu just added is the same as the last item in the list - normal
		assertSame("Test that Menu is added to the end of the list.", menu2, menuList.get(1));

		// Add a menu that already exists in the list
		C206_CaseStudy.addMenuMethod(menuList, menu2);
		assertEquals("Test that the Menu arraylist size is unchanged.", 2, menuList.size());

		//Add a Menu that has missing detail to check that it does not add into the arraylist successfully - error
		Menu menu_missing = new Menu("", "Steamed, Roasted, Soups, Noodles",2.3, 00001);
		C206_CaseStudy.addMenuMethod(menuList, menu_missing);
		assertEquals("Test that the Menu arraylist size is unchange.", 2, menuList.size());

	}

	// KELVIN
	@Test
	public void c206_testDeleteMenu() {
		// Test if the Menu list is not null and empty
		assertNotNull("Test if there is valid Menu arraylist to retrieve menu from", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());

		// Test that the list is not empty before deleting
		C206_CaseStudy.addMenuMethod(menuList, menu1);
		C206_CaseStudy.addMenuMethod(menuList, menu2);
		assertEquals("Test that Menu arraylist size is 2.", 2, menuList.size());

		// The size of the list decreases by one after deleting a menu
		C206_CaseStudy.delMenuID(menuList, 1);
		assertEquals("Test that Menu arraylist size is 1", 1, menuList.size());

		// Test the menu not in the list is not deleted, the size of the list remains the same
		C206_CaseStudy.delMenuID(menuList, 21);
		assertEquals("Test that the size of the menulist remain the same (1)", 1, menuList.size());


	}

	// KELVIN
	@Test
	public void c206_testviewAllMenus() {
		// Test Case 1
		// Test if Menu list is not null and empty
		assertNotNull("Test if there is valid Menus arraylist to add to", menuList);
		assertEquals("Test that the menu arraylist is empty", 0, menuList.size());

		// Attempt to retrieve the Menu
		String allMenu = C206_CaseStudy.viewAllMenu(menuList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allMenu);

		C206_CaseStudy.addMenuMethod(menuList, menu1);
		C206_CaseStudy.addMenuMethod(menuList, menu2);

		// Test that the list is not empty
		assertEquals("Test that menu arraylist size is 2 ", 2, menuList.size());

		// Attempt to retrieve the menus
		allMenu = C206_CaseStudy.viewAllMenu(menuList);
		testOutput = String.format("%-10d %-20s %-20.2f %-10s\n", 1, "Italian", 7.99, "Zuppe e salse(soups and sauces), Pane(bread), Drinks");
		testOutput += String.format("%-10d %-20s %-20.2f %-10s\n", 2, "Indian", 5.99, "South Indian(dosa, Kerala Parotta), North Indian(chappathi, dhal), Drinks");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allMenu);

		// assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@After
	public void tearDown() throws Exception {
		py1 = null;
		py2 = null;
		paymentMethod.clear();

		order1 = null;
		order2 = null;
		orderList.clear();

		user1 = null;
		user2 = null;
		UserList.clear();

		vendor1 = null;
		vendor2 = null;
		vendorList.clear();
		
		menu1 = null;
		menu2 = null;
		menuList.clear();
	}
}

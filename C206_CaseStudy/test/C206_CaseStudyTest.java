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

	@Before
	public void setUp() throws Exception {
		py1 = new PaymentMethod("John", "111222", 1234, "OCBC", "VISA");
		py2 = new PaymentMethod("Marry", "222111", 4321, "DBS", "NETS");

		order1 = new Order("OD25", "Johnny", "87459845", "2");
		order2 = new Order("OD26", "Lily", "85478956", "1");
		orderList = new ArrayList<Order>();

		UserList = new ArrayList<User>();
		user1 = new User("760001", "Johnny", "87459845", "Johnny123@gmail.com");
		user2 = new User("760002", "Lily", "85478956", "Lily123@gmail.com");

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

		// test if the expected output string same as the list of Payment Methods
		// retrieved
		// from the SourceCentre
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

		// Test if the remaining payment method is the one that wasn't deleted - normal
		assertSame("Test that the remaining PaymentMethod is the correct one", py1, paymentMethod.get(0));

		// Given a payment method which isn't in the list,
		// Test if the size of the list doesn't change and remain the same.
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
		assertEquals("Test that the Camcorder arraylist size is now 2.", 2, orderList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that Order is added to the end of the list.", order2, orderList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());

		// Add an item that has missing detail to check that it does not add into the arraylist successfully
		Order od_missing = new Order("OD29", "", "96514485", "2");
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
		testOutput = String.format("%-10s %-20s %-20s %-10s\n", "OD25", "Johnny", "87459845", "2");
		testOutput += String.format("%-10s %-20s %-20s %-10s\n", "OD26", "Lily", "85478956", "1");

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
		// Test if the Order list is not null and empty
		assertNotNull("Test if there is valid User arraylist to retrieve user from", UserList);
		assertEquals("Test that the User arraylist is empty.", 0, UserList.size());

		// Test that the list is not empty before deleting
		C206_CaseStudy.addUserMethod(UserList, user1);
		C206_CaseStudy.addUserMethod(UserList, user2);
		assertEquals("Test that User arraylist size is 2.", 2, UserList.size());

		// The size of the list decreases by one after deleting one order
		C206_CaseStudy.delUserID(UserList, "760001");
		assertEquals("Test that User arraylist size is 1", 1, UserList.size());

		// Test the order not in the list is not deleted, the size of the list remains
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

		// Attempt to retrieve the Order
		String allUser = C206_CaseStudy.retrieveAllUsers(UserList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);

		C206_CaseStudy.addUserMethod(UserList, user1);
		C206_CaseStudy.addUserMethod(UserList, user2);

		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, UserList.size());

		// Attempt to retrieve the Order
		allUser = C206_CaseStudy.retrieveAllUsers(UserList);
		testOutput = String.format("%-10s %-20s %-20s %-10s\n", "760001", "Johnny", "87459845", "Johnny123@gmail.com");
		testOutput += String.format("%-10s %-20s %-20s %-10s\n", "760002", "Lily", "85478956", "Lily123@gmail.com");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);

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
	}
}

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
	private Order order2 ;
	private ArrayList<Order> orderList;

	@Before
	public void setUp() throws Exception {
		py1 = new PaymentMethod("John", "111222", 1234, "OCBC", "VISA");
		py2 = new PaymentMethod("Marry", "222111", 4321, "DBS", "NETS");
		
		order1= new Order("OD25","Johnny","87459845");
		order2= new Order("OD26","Lily","85478956");
		orderList = new ArrayList<Order>();
	}

	@Test
	public void doAddPaymentMethod() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid PaymentInfo arraylist to add to", paymentMethod);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addPaymentMethod(paymentMethod, py1);
		assertEquals("Check that PaymentInfo arraylist size is 1", 1, paymentMethod.size());
		assertSame("Check that PaymentInfo is added", py1, paymentMethod.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addPaymentMethod(paymentMethod, py2);
		assertEquals("Check that PaymentInfo arraylist size is 2", 2, paymentMethod.size());
		assertSame("Check that PaymentInfo is added", py2, paymentMethod.get(1));
	}

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
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0011", "My Google Chromebook 1st", "Yes", "",
				"Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "",
				"Win 10");
		assertEquals("Test that ViewAllPaymentMethod", testOutput, allPaymentMethod);
	}

	@Test
	public void testDeletePaymentMethod() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid PaymentInfo arraylist to retrieve item from", paymentMethod);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addPaymentMethod(paymentMethod, py1);
		C206_CaseStudy.addPaymentMethod(paymentMethod, py2);
		assertEquals("Test that PaymentMethod arraylist size is 2", 2, paymentMethod.size());
		
		// Given a list with 2 items, test if the size of the list becomes 1 after deleting one - normal
		C206_CaseStudy.deletePaymentMethod(paymentMethod, py2);
		assertEquals("Test that PaymentMethod arraylist size is 1", 1, paymentMethod.size());
		
		// Test if the remaining payment method is the one that wasn't deleted - normal
		assertEquals("Test that the remaining PaymentMethod is the correct one", py1, paymentMethod.get(0));
		
	}
	//XUE NI
	@Test
	public void c206_testAddOrder() {
		//fail("Not yet implemented"); 
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addNewOrder(orderList, order1);
		assertEquals("Test that the Order arraylist size is 1.", 1, orderList.size());
		
		// Add an item
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertEquals("Test that the Camcorder arraylist size is now 2.", 2, orderList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Order is added to the end of the list.", order2, orderList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());

		// Add an item that has missing detail
		Order od_missing = new Order("OD29", "", "96514485");
		C206_CaseStudy.addNewOrder(orderList, od_missing);
		assertEquals("Test that the Order arraylist size is unchange.", 2, orderList.size());
		
	}
	//XUE NI
	@Test
	public void c206_testRetrieveAllOrders() {
		//Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Order arraylist to add to", orderList);
		assertEquals("Test that the Order arraylist is empty.", 0, orderList.size());
		
		// Attempt to retrieve the Order 
		String allOrder= C206_CaseStudy.retrieveAllOrders(orderList);
		String testOutput = "";
		
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allOrder);
		
		C206_CaseStudy.addNewOrder(orderList, order1);
		C206_CaseStudy.addNewOrder(orderList, order2);
		
		// Test that the list is not empty
		assertEquals("Test that Order arraylist size is 2.", 2, orderList.size());
		
		// Attempt to retrieve the Order 
		allOrder= C206_CaseStudy.retrieveAllOrders(orderList);
		testOutput = String.format("%-10s %-30s %-20s\n","OD25", "Johnny", "87459845");
		testOutput += String.format("%-10s %-30s %-20s\n","OD26", "Lily", "85478956");
		
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allOrder);
		
		
		//assertTrue("C206_CaseStudy_SampleTest ",true); 
	}
	//XUE NI
	@Test
	public void c206_testDeleteOrder() {
		//Test Case 1 - Order delete successfully
		C206_CaseStudy.addNewOrder(orderList, order1);
		C206_CaseStudy.addNewOrder(orderList, order2);
		assertNotNull("test if there is valid Order arraylist to delete from", orderList);
		
		/*C206_CaseStudy.deleteOrder(orderList, order1.getOrderId());
		Boolean delete = C206_CaseStudy.deleteOrder(orderList, "OD25" );
		assertTrue("Test if an available order to delete?", delete);
		
		// Test Case 2 - Order not found
		delete = C206_CaseStudy.deleteOrder(orderList, "OD33");
		assertFalse("Test that the deletion fails.", delete);
		*/
		
}

	@After
	public void tearDown() throws Exception {
		py1 = null;
		py2 = null;
		paymentMethod.clear();
	}
}

import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private ArrayList<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();
	private PaymentMethod py1;
	private PaymentMethod py2;

	@Before
	public void setUp() throws Exception {
		py1 = new PaymentMethod("John", "111222", 1234, "OCBC", "VISA");
		py2 = new PaymentMethod("Marry", "222111", 4321, "DBS", "NETS");
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

	@After
	public void tearDown() throws Exception {
		py1 = null;
		py2 = null;
		paymentMethod.clear();
	}
}

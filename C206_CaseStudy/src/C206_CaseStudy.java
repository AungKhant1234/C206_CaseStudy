import java.util.*;
import java.util.ArrayList;

public class C206_CaseStudy {

	private ArrayList<PaymentMethod> paymentInfo = new ArrayList<PaymentMethod>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		orderList.add(new Order("OD25", "Johnny", "87459845"));
		orderList.add(new Order("OD26", "Lily", "85478956"));
		
		int option = Helper.readInt("Enter an option to proceed > ");
		
		while (option != 6) {
			if (option == 1) {
			
			} else if (option == 2) {
				int activity = Helper.readInt("Enter the value for Order > ");
				
				if(activity==1) {
					Order od= inputOrder();
					C206_CaseStudy.addNewOrder(orderList, od);
					
				}else if(activity==2) {
					C206_CaseStudy.viewAllOrders(orderList);
					
				}else if(activity==3) {
					String id = inputOrderID();
					//C206_CaseStudy.deleteOrder(orderList, id);
				}else if(activity==4) {
					System.out.println("Bye");
				}

			} else if (option == 3) {

			} else if (option == 4) {

			} else if (option == 5) {
				
			}else if(option==6){
				System.out.println("THANK YOU FOR USING OUR LUNCH BOX ORDERING SYSTEM");
			}
		}

	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static PaymentMethod inputPaymentMethod() {
		String cardHolder = Helper.readString("Enter card holder name > ");
		String postalCode = Helper.readString("Enter postal code > ");
		int cardNum = Helper.readInt("Enter card number > ");
		int last4Digit = Integer.parseInt(Integer.toString(cardNum).substring(12));
		int expiryDate = Helper.readInt("Enter expiry Date > ");
		int cvv = Helper.readInt("Enter cvv > ");
		String bankName = Helper.readString("Enter bank name > ");
		String cardType = Helper.readString("Enter card type > ");

		PaymentMethod py = new PaymentMethod(cardHolder, postalCode, last4Digit, bankName, cardType);

		return py;
	}

	public static void addPaymentMethod(ArrayList<PaymentMethod> paymentMethod, PaymentMethod py) {
		PaymentMethod payment;
		for (int i = 0; i < paymentMethod.size(); i++) {
			payment = paymentMethod.get(i);
			if (payment.getLast4Digit() == py.getLast4Digit())
				return;
		}
		if (py.getCardHolder().isEmpty() || py.getBankName().isEmpty() || py.getCardType().isEmpty()
				|| py.getPostalCode().isEmpty() || (py.getLast4Digit() == 0)) {
			return;
		}
		paymentMethod.add(py);
	}

	public static String retrieveAllPaymentMethod(ArrayList<PaymentMethod> paymentMethod) {

		return "";
	}

	public static void deletePaymentMethod(ArrayList<PaymentMethod> paymentMethod, PaymentMethod py) {

	}
	// XUENI-------------------RETRIEVE ALL ORDER LIST FROM orderList IN ORDER TO VIEW IT-----------------------------------
		public static String retrieveAllOrders(ArrayList<Order> orderList) {
			String output = "";

			for (int i = 0; i < orderList.size(); i++) {
				output += String.format("%-10s %-20s %-20s\n", orderList.get(i).getOrderId(),
						orderList.get(i).getCustomerName(), orderList.get(i).getMobileNumber());
			}
			return output;
		}

		// XUENI-----------------------VIEW ALL ORDER FROM THE ORDERLIST----------------------------------------
		public static void viewAllOrders(ArrayList<Order> orderList) {
			C206_CaseStudy.setHeader("ORDER LIST");
			String output = String.format("%-10s %-20s %-20s \n", "ORDER ID", "CUSTOMER NAME", "MOBILE NUMBER");
			output += retrieveAllOrders(orderList);
			System.out.println(output);
		}

		// XUENI----------------------ADD AN ORDER TO THE ORDERLIST--------------------------------------------------
		public static Order inputOrder() {
			String OrderID = Helper.readString("Enter Order ID > ");
			String customerName = Helper.readString("Enter Customer Name > ");
			String mobileNo = Helper.readString("Enter Mobile Number > ");

			Order OD = new Order(OrderID, customerName, mobileNo);
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
			System.out.println("Order Added");
		}
		//XUENI------------------------DELETE AN EXSITING ORDER FROM ORDERLIST---------------------------------
		public static String inputOrderID() {
			String OrderID = Helper.readString("Enter Order ID > ");
			
			return OrderID;
		}
		
		
		public static boolean deleteOrder(ArrayList<Order> orderList, Order OrderID) {
			Order item;
			for (int i = 0; i < orderList.size(); i++) {
				item=orderList.get(i);
				if (OrderID.equals(item.getOrderId())) {
					orderList.remove(i);
					return true;
					
				} else {
					System.out.println("No order found");
				}
			}
			return false;
		}

}

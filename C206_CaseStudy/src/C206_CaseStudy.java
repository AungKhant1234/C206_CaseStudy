import java.util.*;

public class C206_CaseStudy {

	private ArrayList<PaymentMethod> paymentInfo = new ArrayList<PaymentMethod>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = 0;
		while (option != 6) {
			if (option == 1) {
			
			} else if (option == 2) {

			} else if (option == 3) {

			} else if (option == 4) {

			} else if (option == 5) {
				
			} else {
				System.out.println("THANK YOU FOR USING OUR LUNCH BOX ORDERING SYSTEM");
			}
		}

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

}

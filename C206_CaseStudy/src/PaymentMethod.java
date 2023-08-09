
public class PaymentMethod {

	private String cardHolder;
	private String postalCode;
	private int last4Digit;
	private String bankName;
	private String cardType;
	
	public PaymentMethod(String cardHolder, String postalCode, int last4Digit, String bankName, String cardType) {
	
		this.cardHolder = cardHolder;
		this.postalCode = postalCode;
		this.last4Digit = last4Digit;
		this.bankName = bankName;
		this.cardType = cardType;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public int getLast4Digit() {
		return last4Digit;
	}

	public String getBankName() {
		return bankName;
	}
	
	
}


public class Order {
	private String OrderId;
	private String customerName;
	private String mobileNumber;
	private String quantity;

	public Order(String OrderId, String customerName, String mobileNumber, String quantity) {
		this.OrderId = OrderId;
		this.customerName=customerName;
		this.mobileNumber=mobileNumber;
		this.quantity=quantity;
	}
	
	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getquantity() {
		return quantity;
	}
	
	public void setquantity(String quantity) {
		this.quantity=quantity;
	}

	public String toString(){
		String output = "";
		// Write your codes here
		return output;
	}

}

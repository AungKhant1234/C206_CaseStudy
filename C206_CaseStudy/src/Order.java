
public class Order {
	private String OrderId;
	private String customerName;
	private String mobileNumber;
	private String quantity;
	private String itemName;

	public Order(String OrderId, String customerName, String mobileNumber, String quantity, String itemName) {
		this.OrderId = OrderId;
		this.customerName=customerName;
		this.mobileNumber=mobileNumber;
		this.quantity=quantity;
		this.itemName = itemName;
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
	
	public String getitemName() {
		return itemName;
	}
	
	public void setitemName(String itemName) {
		this.itemName = itemName;
	}

	public String toString(){
		String orderInfo =(String.format("%-10s %-20s %-20s %-10s %-15s", 
				OrderId, customerName, mobileNumber, quantity, itemName));
		
		return orderInfo;
	}

}

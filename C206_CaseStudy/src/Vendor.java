
public class Vendor {
	private String VendorId;
	private String vendorName;
	private String mobileNumber;
	private String email;

	public Vendor(String VendorId, String vendorName, String mobileNumber, String email) {
		this.VendorId = VendorId;
		this.vendorName = vendorName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getVendorId() {
		return VendorId;
	}

	public void setVendorId(String VendorId) {
		this.VendorId = VendorId;
	}

	public String getvendorName() {
		return vendorName;
	}

	public void setvendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	 

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

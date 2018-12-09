package componentsV2;

import java.time.LocalDate;

public class PremiumSubscription extends Subscription{
	float paymentTotal;
	long creditCardNumber;
	String workOrganization;
	String workAddress;
	public PremiumSubscription(String email, float paymentTotal, long creditCardNumber, String workOrganization,
			String workAddress) {
		super(1000, email);
		this.paymentTotal = paymentTotal;
		this.creditCardNumber = creditCardNumber;
		this.workOrganization = workOrganization;
		this.workAddress = workAddress;
	}
	public PremiumSubscription(LocalDate subscriptionDate, LocalDate expiryDate, String email, float paymentTotal,
			long creditCardNumber, String workOrganization, String workAddress) {
		super(1000, subscriptionDate, expiryDate, email);
		this.paymentTotal = paymentTotal;
		this.creditCardNumber = creditCardNumber;
		this.workOrganization = workOrganization;
		this.workAddress = workAddress;
	}
	public float getPaymentTotal() {
		return paymentTotal;
	}
	public void setPaymentTotal(float paymentTotal) {
		this.paymentTotal = paymentTotal;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getWorkOrganization() {
		return workOrganization;
	}
	public void setWorkOrganization(String workOrganization) {
		this.workOrganization = workOrganization;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	
	
}

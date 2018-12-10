package componentsV2;

import java.time.LocalDate;

public abstract class Subscription {

	private int songLimit;
	private LocalDate subscriptionDate;
	private LocalDate expiryDate;
	private String email;
	
	public Subscription(int songLimit, String email)
	{
		this.songLimit = songLimit;
		this.subscriptionDate = LocalDate.now();
		this.expiryDate = this.subscriptionDate.plusDays(30);
		this.email = email;
	}
	
	public Subscription(int songLimit, LocalDate subscriptionDate, LocalDate expiryDate, String email)
	{
		this.songLimit = songLimit;
		this.subscriptionDate = subscriptionDate;
		this.expiryDate = expiryDate;
		this.email = email;
	}

	public int getSongLimit() {
		return songLimit;
	}

	public void setSongLimit(int songLimit) {
		this.songLimit = songLimit;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void renewSubscription()
	{
		this.expiryDate = this.subscriptionDate.plusDays(30);
	}
	
	public abstract String toString();
}

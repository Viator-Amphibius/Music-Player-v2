package componentsV2;

import java.time.LocalDate;

public class PublicSubscription extends Subscription{

	private int additionalSongLimit;

	public PublicSubscription(String email) {
		super(1, email);
		this.additionalSongLimit = 0;
	}

	public PublicSubscription(LocalDate subscriptionDate, LocalDate expiryDate, String email) {
		super(1, subscriptionDate, expiryDate, email);
		this.additionalSongLimit = 0;
	}

	public int getAdditionalSongLimit() {
		return additionalSongLimit;
	}

	public void setAdditionalSongLimit(int additionalSongLimit) {
		this.additionalSongLimit = additionalSongLimit;
	}
	
	public void IncreaseSongLimits()
	{
		long subscriptionEpoch = this.getSubscriptionDate().toEpochDay();
		long currentEpoch = LocalDate.now().toEpochDay();
		long difference = currentEpoch - subscriptionEpoch;
		if(difference > 6*30)
		{
			additionalSongLimit += (int)((difference-6*30)/30);
		}
	}
	
}

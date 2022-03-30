package pojos;
//Value type of the POJO : component in hibernate jargon
//CAN'T add @Entity n @Id annotations

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdharCard {
	// card number , creation date , location
	@Column(name = "card_number", unique = true, length = 20)
	private String cardNumber;
	@Column(name = "creation_date")
	private LocalDate creationDate;
	@Column(length = 30)
	private String location;

	public AdharCard() {
		// TODO Auto-generated constructor stub
	}

	public AdharCard(String cardNumber, LocalDate creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		this.location = location;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + ", location=" + location
				+ "]";
	}

}

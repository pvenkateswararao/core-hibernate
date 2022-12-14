package com.simple.hibernate.app.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="access_card")
public class AccessCard {

	@Id
	@Column(name="card_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cardId;

	@Column(name="card_number")
	String cardNumber;


	@OneToOne(mappedBy = "accessCard")
	private Customer customer;
	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	

	@Override
	public String toString() {
		return "AccessCard [cardId=" + cardId + ", cardNumber=" + cardNumber + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}

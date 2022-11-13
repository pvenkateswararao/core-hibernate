package com.simple.hibernate.app.oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customer_id;
	
	@Column(name="name")
	String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cardId")
	private AccessCard accessCard;
	
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccessCard getAccessCard() {
		return accessCard;
	}

	public void setAccessCard(AccessCard accessCard) {
		this.accessCard = accessCard;
	}
	
}

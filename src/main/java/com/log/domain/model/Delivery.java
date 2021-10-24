package com.log.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.log.domain.exceptions.Exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Client client;
	
	@Embedded
	private Recipient recipient;
	
	private BigDecimal tax;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> ocurrences = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusDelivery statusDelivery;
	
	@Column(name = "date_order")
	private OffsetDateTime orderDate;
	
	@Column(name = "date_finish_order")
	private OffsetDateTime endOfOrderDate;
	
	public Occurrence recordOccurrence(String description) {
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setDate(OffsetDateTime.now());
		occurrence.setDelivery(this);
		
		this.getOcurrences().add(occurrence);
		
		return occurrence;
	}
	
	public void checkout() {
		
		if(this.cantCheckout()) {
			throw new Exceptions("Entrega não pode ser finalizada.");
		} else {
		this.setEndOfOrderDate(OffsetDateTime.now());
		this.setStatusDelivery(StatusDelivery.CHECKOUTED);
		}
	}
	
	public boolean canCheckout() {
		return StatusDelivery.PENDING.equals(this.getStatusDelivery());
	}
	
	public boolean cantCheckout() {
		return !canCheckout();
	}
}

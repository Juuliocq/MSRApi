package com.log.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.log.domain.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeliveryRepresentationalModel {

	private Long id;
	private ClientResumedModel client;
	private RecipientRepresentationalModel recipient;
	private BigDecimal tax;
	private StatusDelivery status;
	private OffsetDateTime orderDate;
	private OffsetDateTime endOfOrderDate;
	
}

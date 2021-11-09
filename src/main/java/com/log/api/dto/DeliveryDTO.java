package com.log.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.log.domain.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeliveryDTO {

	private Long id;
	private ClientResumedDTO client;
	private RecipientDTO recipient;
	private BigDecimal tax;
	private StatusDelivery status;
	private OffsetDateTime orderDate;
	private OffsetDateTime endOfOrderDate;
	
}

package com.log.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInput {

	@Valid
	@NotNull
	private ClientIdInput clientIdInput;
	
	@Valid
	@NotNull
	private RecipientInput recipientInput;
	
	@NotNull
	private BigDecimal tax;
}

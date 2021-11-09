package com.log.api.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class RecipientInput {

	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String houseNumber;
	
	private String complement;
	
	@NotBlank
	private String district;
}

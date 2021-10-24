package com.log.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.log.api.model.DeliveryRepresentationalModel;
import com.log.api.model.input.DeliveryInput;
import com.log.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

	private ModelMapper modelMapper;
	
	public DeliveryRepresentationalModel toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryRepresentationalModel.class);
	}
	
	public List<DeliveryRepresentationalModel> toCollectionModel(List<Delivery> deliveries){
		return deliveries.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryInput deliveryInput) {
		return modelMapper.map(deliveryInput, Delivery.class);
	}
}

package com.log.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.log.api.dto.DeliveryDTO;
import com.log.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

	private ModelMapper modelMapper;
	
	public DeliveryDTO toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryDTO.class);
	}
	
	public List<DeliveryDTO> toCollectionModel(List<Delivery> deliveries){
		return deliveries.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryDTO deliveryDTO) {
		return modelMapper.map(deliveryDTO, Delivery.class);
	}
}

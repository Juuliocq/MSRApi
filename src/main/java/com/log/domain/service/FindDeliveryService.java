package com.log.domain.service;

import org.springframework.stereotype.Service;

import com.log.domain.exceptions.EntityNotFoundException;
import com.log.domain.model.Delivery;
import com.log.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindDeliveryService {
	
	private DeliveryRepository deliveryRepository;
	
	public Delivery find(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada!"));
	}

}

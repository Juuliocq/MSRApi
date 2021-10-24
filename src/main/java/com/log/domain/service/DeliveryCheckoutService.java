package com.log.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.domain.model.Delivery;
import com.log.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryCheckoutService {

	private DeliveryRepository deliveryRepository;
	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public void checkout(Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		delivery.checkout();
		
		deliveryRepository.save(delivery);
	}
}

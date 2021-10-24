package com.log.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.domain.model.Client;
import com.log.domain.model.Delivery;
import com.log.domain.model.StatusDelivery;
import com.log.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateDeliveryService {

	private CatalogClientService catalogClientService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		Client client = catalogClientService.find(delivery.getClient().getId());
		
		
		delivery.setClient(client);
		delivery.setStatusDelivery(StatusDelivery.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
}

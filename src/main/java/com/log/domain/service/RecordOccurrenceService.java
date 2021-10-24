package com.log.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.domain.model.Delivery;
import com.log.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecordOccurrenceService {
	
	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public Occurrence record(Long deliveryId, String description) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		return delivery.recordOccurrence(description);
	}

}

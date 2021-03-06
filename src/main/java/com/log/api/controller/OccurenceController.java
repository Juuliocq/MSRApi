package com.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.log.api.assembler.OccurrenceAssembler;
import com.log.api.dto.OccurrenceDTO;
import com.log.domain.model.Delivery;
import com.log.domain.model.Occurrence;
import com.log.domain.service.FindDeliveryService;
import com.log.domain.service.RecordOccurrenceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("deliveries/{deliveryId}/occurrences")
public class OccurenceController {

	private RecordOccurrenceService recordOccurrenceService;
	private OccurrenceAssembler occurrenceAssembler;
	private FindDeliveryService findDeliveryService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceDTO record(@PathVariable Long deliveryId, @Valid @RequestBody OccurrenceDTO occurrenceDTO) {
		Occurrence recordedOccurrence = recordOccurrenceService.record(deliveryId, occurrenceDTO.getDescription());

		return occurrenceAssembler.toModel(recordedOccurrence);
	}

	@GetMapping
	public List<OccurrenceDTO> find(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);

		return occurrenceAssembler.toCollectionModel(delivery.getOcurrences());
	}

	@GetMapping
	public List<OccurrenceDTO> list(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);

		return occurrenceAssembler.toCollectionModel(delivery.getOcurrences());
	}
}

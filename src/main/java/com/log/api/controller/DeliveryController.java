package com.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.log.api.assembler.DeliveryAssembler;
import com.log.api.model.DeliveryRepresentationalModel;
import com.log.api.model.input.DeliveryInput;
import com.log.domain.model.Delivery;
import com.log.domain.repository.DeliveryRepository;
import com.log.domain.service.CreateDeliveryService;
import com.log.domain.service.DeliveryCheckoutService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	private DeliveryRepository deliveryRepository;
	private CreateDeliveryService createDeliveryService;
	private DeliveryAssembler deliveryAssembler;
	private DeliveryCheckoutService deliveryCheckoutService;
	
	@GetMapping
	public List<DeliveryRepresentationalModel> list(){
		return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryRepresentationalModel> find(@PathVariable long deliveryId){
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public DeliveryRepresentationalModel requestDelivery(@Valid @RequestBody DeliveryInput deliveryInput) {
		Delivery delivery = deliveryAssembler.toEntity(deliveryInput);
		
		return deliveryAssembler.toModel(createDeliveryService.request(delivery));
	}
	
	@PutMapping("/{deliveryId}/checkout")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void checkout(@PathVariable Long deliveryId) {
		deliveryCheckoutService.checkout(deliveryId);
	}
}

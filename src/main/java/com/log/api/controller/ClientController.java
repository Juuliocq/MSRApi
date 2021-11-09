package com.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.log.api.assembler.ClientAssembler;
import com.log.api.dto.ClientDTO;
import com.log.domain.model.Client;
import com.log.domain.repository.ClientRepository;
import com.log.domain.service.CatalogClientService;

import lombok.AllArgsConstructor;

//NOTAÇÃO DO LOMBOK, GERA CONSTRUTOR COM TODOS OS ARGUMENTOS
//@AllArgsConstructor

@RequestMapping("/clients")
@RestController
@AllArgsConstructor
public class ClientController {

	// @Autowired
	private ClientRepository clientRepository;

	// @Autowired
	private CatalogClientService catalogClientService;
	private ClientAssembler clientAssembler;

	// INJEÇÃO POR CONSTRUTOR
	/*
	 * ClientController(ClientRepository clienteRepository){ this.clientRepository =
	 * clientRepository; super(); }
	 */

	@GetMapping
	public List<ClientDTO> list() {
		return clientAssembler.toCollectionModel(clientRepository.findAll());
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<ClientDTO> find(@PathVariable long clientId) {

		return clientRepository.findById(clientId).map(client -> ResponseEntity.ok(clientAssembler.toModel(client)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDTO add(@Valid @RequestBody ClientDTO clientDTO) {
		Client client = clientAssembler.toEntity(clientDTO);
		return clientAssembler.toModel(catalogClientService.save(client));
	}

	@PutMapping("/{clientId}")
	public ResponseEntity<ClientDTO> update(@PathVariable long clientId, @Valid @RequestBody ClientDTO clientInput) {
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		} else {

			Client client = clientAssembler.toEntity(clientInput);
			clientRepository.save(client);
			return ResponseEntity.ok(clientAssembler.toModel(client));
		}
	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> del(@PathVariable long clientId) {
		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		} else {
			catalogClientService.delete(clientId);
			return ResponseEntity.noContent().build();
		}
	}

}

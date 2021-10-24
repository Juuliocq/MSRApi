package com.log.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.domain.exceptions.Exceptions;
import com.log.domain.model.Client;
import com.log.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalogClientService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client save(Client client) {
		boolean emailInUse = clientRepository.findByEmail(client.getEmail())
				.stream().anyMatch(clientExists -> !clientExists.equals(client));
		
		if(emailInUse) {
			throw new Exceptions("Já existe um cliente cadastrado com esse email!");
		} else {
		return clientRepository.save(client);
		}
	}
	
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
	
	public Client find(Long clientId) {
		return clientRepository.findById(clientId)
		.orElseThrow(() -> new Exceptions("Cliente não encontrado!"));
	}
	
}

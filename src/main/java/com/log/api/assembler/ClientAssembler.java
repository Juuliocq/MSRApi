package com.log.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.log.api.dto.ClientDTO;
import com.log.domain.model.Client;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ClientAssembler {
	
	private ModelMapper modelMapper;

	public ClientDTO toModel(Client client) {
		return modelMapper.map(client, ClientDTO.class);
	}
	
	public List<ClientDTO> toCollectionModel(List<Client> clients){
		return clients.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Client toEntity(ClientDTO clientDTO) {
		return modelMapper.map(clientDTO, Client.class);
	}
}

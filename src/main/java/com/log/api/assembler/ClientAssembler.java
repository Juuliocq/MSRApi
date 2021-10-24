package com.log.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.log.api.model.ClientRepresentationalModel;
import com.log.api.model.input.ClientInput;
import com.log.domain.model.Client;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ClientAssembler {
	
	private ModelMapper modelMapper;

	public ClientRepresentationalModel toModel(Client client) {
		return modelMapper.map(client, ClientRepresentationalModel.class);
	}
	
	public List<ClientRepresentationalModel> toCollectionModel(List<Client> clients){
		return clients.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Client toEntity(ClientInput clientInput) {
		return modelMapper.map(clientInput, Client.class);
	}
}

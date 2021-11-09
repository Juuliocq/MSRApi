package com.log.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.log.api.dto.OccurrenceDTO;
import com.log.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {
	
	private ModelMapper modelMapper;
	
	public OccurrenceDTO toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceDTO.class);
	}
	
	public List<OccurrenceDTO> toCollectionModel(List<Occurrence> Occurrences){
		return Occurrences.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Occurrence toEntity(OccurrenceDTO occurrenceDTO) {
		return modelMapper.map(occurrenceDTO, Occurrence.class);
	}

}

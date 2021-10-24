package com.log.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.log.api.model.OccurrenceRepresentationalModel;
import com.log.api.model.input.OccurrenceInput;
import com.log.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {
	
	private ModelMapper modelMapper;
	
	public OccurrenceRepresentationalModel toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceRepresentationalModel.class);
	}
	
	public List<OccurrenceRepresentationalModel> toCollectionModel(List<Occurrence> Occurrences){
		return Occurrences.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Occurrence toEntity(OccurrenceInput occurrenceInput) {
		return modelMapper.map(occurrenceInput, Occurrence.class);
	}

}

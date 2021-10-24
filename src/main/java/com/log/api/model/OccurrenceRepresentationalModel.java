package com.log.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceRepresentationalModel {

	private Long id;
	private String description;
	private OffsetDateTime date;
}

package com.test.actividades.domain.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

	private Integer idActivity;
	
	@NotNull
	@NotEmpty
	private String state;
	
	@NotNull
	@NotEmpty
	private LocalDateTime estimatedDate;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private Employee employeeId;
}

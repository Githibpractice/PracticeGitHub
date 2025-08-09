package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String job;
	@NonNull
	private Double sal;
	private Double netSal;
	private Double grossSal;

}

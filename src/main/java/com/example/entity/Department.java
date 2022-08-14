package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;

	@NotBlank(message = "Please add DepartmentName")
	private String departementName;
	private String departmentAddress;
	private String departmentCode;
	/*
	 * @Length(max =5 ,min =1)
	 * 
	 * @Size(max = 10, min = 0)
	 * 
	 * @Email
	 * 
	 * @Positive
	 * 
	 * @Negative
	 * 
	 * @PositiveOrZero
	 * 
	 * @NegativeOrZero
	 * 
	 * @Future
	 * 
	 * @FutureOrPresent
	 * 
	 * @PastOrPresent
	 */




}

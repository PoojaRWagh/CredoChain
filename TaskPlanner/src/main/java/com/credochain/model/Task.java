package com.credochain.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="tasks")
public class Task {
	private int taskid;
	private String title,description,createdBy,assignedTo;
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private LocalDate  completedon;
//	@JsonEnumDefaultValue
	private String status;

}
    
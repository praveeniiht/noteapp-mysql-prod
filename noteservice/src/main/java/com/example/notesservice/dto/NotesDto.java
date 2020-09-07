package com.example.notesservice.dto;

import lombok.Data;

@Data
public class NotesDto {
	
	private Integer id;
	
	private String title;
	
	private String author;
	
	private String description;
	
	private String status;
	
}

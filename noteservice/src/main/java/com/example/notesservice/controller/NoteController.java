package com.example.notesservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.dto.NotesExceptionResponse;
import com.example.notesservice.exception.NotesException;
import com.example.notesservice.service.NoteService;
@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@GetMapping("/all")
	public ResponseEntity<List<NotesDto>> findAll(){
		return null;
	}
	@PostMapping("/add")
	public ResponseEntity<NotesDto> addNote(@Valid @RequestBody NotesDto note, BindingResult result){
		return null;
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NotesDto> deleteNote(@PathVariable("id") Integer id){
		return null;
	}
	
	@GetMapping("/note/{id}")
	public ResponseEntity<NotesDto> findById(@PathVariable("id") Integer id){
		return null;
	}
	
	@PutMapping("/update/{id}/{status}")
	public ResponseEntity<NotesDto> updateStatus(@PathVariable("id") Integer id, @PathVariable("status") String status){ 
		return null;
	}
	
	@GetMapping("/findByAuthor/{author}")
	public ResponseEntity<List<NotesDto>> findAllByAuthor(@PathVariable("author") String author){
		return null;
	}
	
	@GetMapping("/findbyStatus/{status}")
	public ResponseEntity<List<NotesDto>> findAllByStatus(@PathVariable("status") String status){
		return null;
	}
	
	@ExceptionHandler(NotesException.class)
	public ResponseEntity<NotesExceptionResponse> NotesHandler(NotesException ex){
		NotesExceptionResponse resp = 
				new NotesExceptionResponse(ex.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		
		ResponseEntity<NotesExceptionResponse> response = 
				new ResponseEntity<NotesExceptionResponse>(resp, HttpStatus.BAD_REQUEST);
		return response;
	}
}












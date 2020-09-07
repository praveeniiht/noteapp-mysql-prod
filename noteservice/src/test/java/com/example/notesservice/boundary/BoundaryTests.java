package com.example.notesservice.boundary;
import static com.example.utils.TestUtils.boundaryTestFile;
import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.yakshaAssert;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.notesservice.dto.NotesDto;
import com.example.utils.MasterData;
public class BoundaryTests {
	
	
	private Validator validator;
	
	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	

	@Test
	public void testAuthorNameLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setAuthor("Pra");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	 
	@Test
	public void testTitleLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setTitle("Dev");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	@Test
	public void testDescriptionLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setDescription("Test");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testStatusLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setDescription("ab");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
}

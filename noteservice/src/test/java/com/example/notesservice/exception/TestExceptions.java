package com.example.notesservice.exception;
import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.exceptionTestFile;
import static com.example.utils.TestUtils.yakshaAssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.notesservice.controller.NoteController;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.service.NoteService;

@WebMvcTest(NoteController.class)
@RunWith(SpringRunner.class)
public class TestExceptions {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NoteService noteService;

		// Exception
		@Test
		public void testAddNoteValidation() throws Exception {
			NotesDto notesdto = com.example.utils.MasterData.getNotesDto();
			notesdto.setAuthor("pr");
			Mockito.when(noteService.addNote(notesdto))
			.thenReturn(notesdto);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/noteservice/add")
					.content(com.example.utils.MasterData.asJsonString(notesdto))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
					
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			System.out.println(result.getResponse().getStatus());
			yakshaAssert(currentTest(),
					result.getResponse().getStatus() == 400? true : false,
							exceptionTestFile);
					
		}
	
	
}

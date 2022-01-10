package com.qa.drinksproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.drinksproject.domain.Drink;
import com.qa.drinksproject.service.DrinkService;



@RunWith(SpringRunner.class)
@WebMvcTest
public class DrinkControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private DrinkService service;

	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Pepsi", "fizzy", 1, 330);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/Drink/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(entryAsJSON));
	}

	@Test
	public void readAllTest() throws Exception {
		Drink entry = new Drink("Pepsi", "fizzy", 1, 330);
		List<Drink> output = new ArrayList<>();
		output.add(entry);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.getAll()).thenReturn(output);
		
		mvc.perform(get("/Drink/ReadAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				
	}

	@Test
	public void readbyIdTest() throws Exception {
		Drink entry = new Drink("Pepsi", "fizzy", 1, 330);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.getbyId(1L)).thenReturn(entry);
		
		mvc.perform(get("/Drink/ReadbyId/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}
	

	@Test
	public void updateTest() throws Exception {
		Drink entry = new Drink("Pepsi", "fizzy", 1, 330);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/Drink/Update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(entryAsJSON));

	}

	@Test
	public void deleteTest() throws Exception {
		
		
		Mockito.when(this.service.delete(1L)).thenReturn(true);
		
		mvc.perform(delete("/Drink/Delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
				

	}
}
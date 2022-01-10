package com.qa.drinksproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.drinksproject.domain.Drink;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:drink-schema.sql", "classpath:drink-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DrinkControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired 
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink( "Redbull", "Soft", 3 , 335);
			Drink result = new Drink(2L, "Redbull", "Soft", 3 , 335);

		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(post("/Drink/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	public void readAllTest() throws Exception {
		Drink entry = new Drink("Pepsi", "fizzy", 1, 330);
		List<Drink> output = new ArrayList<>();
		output.add(entry);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/Drink/ReadAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				
	}
	
	
	
}

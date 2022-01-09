package com.qa.drinksproject.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
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
public void createTest() throws JsonProcessingException {
Drink entry = new Drink ( "Pepsi" , "fizzy" ,  1 , 330);
String entryAsJSON = this.mapper.writeValueAsString(entry);

Mockito.when(this.service.create(entry)).thenReturn(entry);


}
}

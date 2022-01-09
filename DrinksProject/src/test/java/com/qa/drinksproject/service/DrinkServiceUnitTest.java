package com.qa.drinksproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.drinksproject.domain.Drink;
import com.qa.drinksproject.repo.DrinkRepo;


@SpringBootTest
public class DrinkServiceUnitTest {
	
	// Auto wiring mocks into the service class

	
		@Autowired
		private DrinkService service;

		// we are mocking the repository class as we don`t want to directly depend on the repo class itself
		 
		
		@MockBean
		private DrinkRepo repo;

		@Test
		public void createTest() {
			
			Drink input  =  new Drink ( "Fanta" , "fizzy" ,  2 , 250);
			Drink output =  new Drink (1L, "Fanta" , "fizzy" ,2 , 250);

			// Here we are testing the actual method within the create method from DrinkService
			 
			
			Mockito.when(this.repo.save(input)).thenReturn(output);

			//  Here we are checking the expected value (output) is the same as the actual value (method itself)
			 

			assertEquals(output, this.service.create(input));

			// Verifies that repo is run 1 time, and that it saves the input
			
			Mockito.verify(this.repo, Mockito.times(1)).save(input);
		}
	}

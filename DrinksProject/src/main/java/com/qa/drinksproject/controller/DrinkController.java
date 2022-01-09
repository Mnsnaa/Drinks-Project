package com.qa.drinksproject.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.drinksproject.domain.Drink;
import com.qa.drinksproject.service.DrinkService;

@RestController
@RequestMapping("/Drink")
public class DrinkController {
	
	private DrinkService service;
	
	private DrinkController (DrinkService service) {
		
		this.service = service;
	}
	
	// create
	@PostMapping("/create")
	public ResponseEntity<Drink> createDrink(@RequestBody Drink drink){
		return new ResponseEntity<Drink>(this.service.create(drink),HttpStatus.CREATED);
		
	}
	
	// Read All
	@GetMapping("/ReadAll")
	public ResponseEntity<List<Drink>> ReadAllDrink(){
		return new ResponseEntity<List<Drink>>(this.service.getAll(),HttpStatus.OK);
	}
	
	// Read by Id
	@GetMapping("/ReadbyId/{id}")
	public ResponseEntity<Drink>getDrink(@PathVariable Long id){
		return new ResponseEntity<Drink>(this.service.getbyId(id),HttpStatus.OK);
		
	}
	
	//Update
	@PutMapping("/Update/{id}")
	public ResponseEntity<Drink>updateDrink(@PathVariable long id , @RequestBody Drink drink){
		return new ResponseEntity<Drink>(this.service.update(id ,  drink), HttpStatus.ACCEPTED);
			
	}
	
	// Delete 
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<Boolean>deleteDrink(@PathVariable long id){
		return(this.service.delete(id))? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT):
		new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);	
	}
}

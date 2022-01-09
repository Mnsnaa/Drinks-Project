package com.qa.drinksproject.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.drinksproject.domain.Drink;
import com.qa.drinksproject.repo.DrinkRepo;

@Service
public class DrinkService implements ServiceMethods<Drink> {
	private DrinkRepo repo;

	// Constructor
	public DrinkService(DrinkRepo repo) {
		this.repo = repo;	
	}
	@Override
	public Drink create ( Drink drink) {
		return this.repo.save(drink);		
	}
	@Override
	public List<Drink> getAll(){
		return this.repo.findAll();
	}
	
	@Override
	public Drink getbyId(long id) {
		return null;	
	}
	
	@Override
	public Drink update(long id, Drink t) {
		return null;
	}
	@Override
	public Boolean delete(long id) {
		return null;
	}	
}


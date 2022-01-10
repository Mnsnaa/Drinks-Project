package com.qa.drinksproject.service;



import java.util.List;


public interface ServiceMethods<T> {

	// Create
	T create (T t);

	// Read all
	List<T> getAll();
	
	// Read by ID
	T getbyId(long id);
	
	// Update 
	T update(long id , T t);

	// Delete 
	Boolean delete(long id);
}


	
	


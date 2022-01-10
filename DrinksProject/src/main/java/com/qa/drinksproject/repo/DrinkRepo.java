package com.qa.drinksproject.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.drinksproject.domain.Drink;



public interface DrinkRepo extends JpaRepository<Drink, Long> {

}

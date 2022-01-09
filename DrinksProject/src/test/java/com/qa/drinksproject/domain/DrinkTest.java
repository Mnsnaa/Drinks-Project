package com.qa.drinksproject.domain;
//import com.qa.drinksproject.domain.Drink;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
 
public class DrinkTest {
	
	
	
@Test
public void testEquals() {
	EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
}

@Test
public void noIdConstructor(){
Drink drink =  new Drink ( "Redbull" , "Soft"  , 3 , 275 );

// to check that nothing is created as null, when we create an object using our constructor

assertNotNull(drink.getName());
assertNotNull(drink.getType());
assertNotNull(drink.getPrice());
assertNotNull(drink.getAmount());

assertEquals(drink.getName(), "Redbull");
assertEquals(drink.getType(), "Soft");
assertEquals(drink.getPrice(), 3);
assertEquals(drink.getAmount(), 275);
}


@Test
public void settersTest() {
Drink drink = new Drink();
drink.setName ("Haut brillion" );
drink.setType ("Alcoholic" );
drink.setPrice (650 );
drink.setAmount (750);
 
assertNotNull(drink.getName());
assertNotNull(drink.getType());
assertNotNull(drink.getPrice());
assertNotNull(drink.getAmount());

assertEquals(drink.getName(), "Haut brillion");
assertEquals(drink.getType(), "Alcoholic");
assertEquals(drink.getPrice(), 650);
assertEquals(drink.getAmount(), 750);
}

}



package com.example.dr_edwards.pet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PetStoreTest {

    @Test
    public void testSellPet_enoughMoney() {
        // Arrange
        PetStore petStore = new PetStore();
        Pet cat = new Cat();

        // Act
        int actual = petStore.sellPet(cat);

        // Assert
        assertEquals(10, actual);
    }

    @Test
    public void testSellPet_notEnoughMoney() {
        // Arrange
        PetStore petStore = new PetStore();
        Pet cat = new Cat();
        Pet dog = new Dog();

        // Act
        int actualCat = petStore.sellPet(cat);
        try {
            int actualDog = petStore.sellPet(dog);
            fail("selling a dog should have failed!");
        } catch (Exception e) {
            // Pass
        }

        // Assert
        assertEquals(10, actualCat);
    }

    @Test
    public void testBuyPet_cat() {
        // Arrange
        Pet cat = new Cat();
        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        PetStore petStore = new PetStore(pets, new PetValueCalculator(), new CashRegister(10));
        int money = 10;

        // Act
        Pet actual = petStore.buyPet(money);

        // Assert
        assertEquals(cat, actual);
    }
}

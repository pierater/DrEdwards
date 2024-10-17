package com.example.dr_edwards.pet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
}

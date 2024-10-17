package com.example.dr_edwards.pet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void testBuyPet_oldStyle() {
        // Arrange
        Pet dog = new Dog();
        PetStore petStore = new PetStore();
        int money = 5;
        petStore.sellPet(dog);

        // Act
        Pet actual = petStore.buyPet(money);

        // Assert
        assertEquals(dog, actual);
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

    @Test
    public void testBuyPet_catNotEnoughMoney() {
        // Arrange
        Pet cat = new Cat();
        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        PetValueCalculator petValueCalculatorMock = mock(PetValueCalculator.class);
        when(petValueCalculatorMock.calculateValueOfPet(eq(cat))).thenReturn(10);
        PetStore petStore = new PetStore(pets, petValueCalculatorMock, new CashRegister(10));
        int money = 10;

        // Act
        Pet actual = petStore.buyPet(money);

        // Assert
        assertEquals(cat, actual);
        verify(petValueCalculatorMock, times(1)).calculateValueOfPet(eq(cat));
    }
}

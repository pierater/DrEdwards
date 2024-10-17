package com.example.dr_edwards.pet;

import java.util.ArrayList;
import java.util.List;

public class PetStore {

    private final List<Pet> petsToSell = new ArrayList<>();
    private int money = 10;


    public Pet buyPet(int money) {
        Pet petToSell = petsToSell.remove(0);
        int valueOfPet = calculateValueOfPet(petToSell);

        if (valueOfPet <= money) {
            this.money += money;
            return petToSell;
        } else {
            throw new RuntimeException("You don't have enough money for this pet!");
        }
    }

    public int sellPet(Pet pet) {
        int valueOfPet = calculateValueOfPet(pet);
        if (valueOfPet <= money) {
            this.money -= valueOfPet;
        } else {
            throw new RuntimeException("The shop doesn't have enough money to buy this pet!");
        }
        petsToSell.add(pet);
        return valueOfPet;
    }

    private int calculateValueOfPet(Pet pet) {
        if (pet.speak().equals("Meow")) {
            return 10;
        } else if (pet.speak().equals("Woof")) {
            return 5;
        } else {
            throw new RuntimeException("I don't know this animal!" + pet.speak());
        }
    }
}

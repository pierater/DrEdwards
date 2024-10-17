package com.example.dr_edwards.pet;

/**
 * Used to determine the value of a pet
 */
public class PetValueCalculator {

    /**
     * Calculates the value of a pet
     * @param pet
     * @return an integer, always positive
     * @throws RuntimeException if the pet is something unknown
     */
    public int calculateValueOfPet(Pet pet) {
        if (pet.speak().equals("Meow")) {
            return 10;
        } else if (pet.speak().equals("Woof")) {
            return 5;
        } else {
            throw new RuntimeException("I don't know this animal!" + pet.speak());
        }
    }
}

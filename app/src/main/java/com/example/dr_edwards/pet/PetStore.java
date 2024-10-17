package com.example.dr_edwards.pet;

import java.util.ArrayList;
import java.util.List;

public class PetStore {

    private final List<Pet> petsToSell;
    private final PetValueCalculator petValueCalculator;
    private final CashRegister cashRegister;

    /**
     * Creates a new <code>PetStore</code> with 10 money and no pets on hand
     */
    public PetStore() {
        this(new ArrayList<>(), new PetValueCalculator(), new CashRegister(10));
    }

    PetStore(List<Pet> petsToSell, PetValueCalculator petValueCalculator, CashRegister cashRegister) {
        this.petsToSell = petsToSell;
        this.petValueCalculator = petValueCalculator;
        this.cashRegister = cashRegister;
    }


    /**
     * Initiates a buy of a pet with no guarantee as to which you will get
     * @param money to offer to buy the pet
     * @return a pet if you offered enough money
     * @throws RuntimeException if not enough money was offered
     */
    public Pet buyPet(int money) {
        Pet petToSell = petsToSell.remove(0);
        int valueOfPet = petValueCalculator.calculateValueOfPet(petToSell);

        if (valueOfPet <= money) {
            this.cashRegister.deposit(money);
            return petToSell;
        } else {
            throw new RuntimeException("You don't have enough money for this pet!");
        }
    }

    /**
     * Attempts to sell a pet to the store
     * @param pet to sell
     * @return the value that the store determined your pet was worth
     * @throws RuntimeException if the store does not have enough money to buy your pet
     */
    public int sellPet(Pet pet) {
        int valueOfPet = petValueCalculator.calculateValueOfPet(pet);
        if (valueOfPet <= cashRegister.getMoneyInRegister()) {
            cashRegister.withdrawal(valueOfPet);
        } else {
            throw new RuntimeException("The shop doesn't have enough money to buy this pet!");
        }
        petsToSell.add(pet);
        return valueOfPet;
    }
}

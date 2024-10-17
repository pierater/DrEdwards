package com.example.dr_edwards.pet;

public class CashRegister {

    private int money;

    public CashRegister(int startMoney) {
        this.money = startMoney;
    }

    /**
     * Deposits money into the register
     * @param moneyToDeposit
     */
    public void deposit(int moneyToDeposit) {
        this.money += moneyToDeposit;
    }

    /**
     * Attempts to withdrawal money from the register
     * @param moneyToWithdrawal
     * @throws RuntimeException if there is not enough money in the register
     */
    public void withdrawal(int moneyToWithdrawal) {
        if (this.money < moneyToWithdrawal) {
            throw new RuntimeException("Not enough money!");
        } else {
            this.money -= moneyToWithdrawal;
        }
    }

    /**
     * @return the current count of money in the register
     */
    public int getMoneyInRegister() {
        return this.money;
    }
}

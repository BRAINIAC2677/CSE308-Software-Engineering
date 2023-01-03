package state;

import vendingmachine.VendingMachine;

public class StockoutState implements State {

    VendingMachine vendingMachine;

    public StockoutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Product is out of stock. Please try again later.");
    }

    @Override
    public void returnMoney() {
    }

    @Override
    public void dispense() {
    }
}
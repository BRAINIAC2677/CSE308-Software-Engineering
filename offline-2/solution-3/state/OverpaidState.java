package state;

import vendingmachine.VendingMachine;

public class OverpaidState implements State {

    VendingMachine vendingMachine;

    public OverpaidState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pay(int amount) {
        System.out.println("You have already paid.");
    }

    @Override
    public void returnMoney() {
        System.out.println("Returning " + (vendingMachine.getBalance() - vendingMachine.getPrice()) + " taka.");
        vendingMachine.setBalance(vendingMachine.getPrice());
        vendingMachine.setState(vendingMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("Product will be dispensed after returning extra money.");
    }
}
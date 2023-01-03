package state;

import vendingmachine.VendingMachine;

public class SoldState implements State {

    VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Take your product first.");
    }

    @Override
    public void returnMoney() {
        System.out.println("No money to return.");
    }

    @Override
    public void dispense() {
        vendingMachine.setBalance(vendingMachine.getBalance() - vendingMachine.getPrice());
        vendingMachine.setQuantity(vendingMachine.getQuantity() - 1);
        if (vendingMachine.getQuantity() == 0) {
            vendingMachine.setState(vendingMachine.getStockoutState());
        } else {
            vendingMachine.setState(vendingMachine.getInitialState());
        }
        System.out.println("Product dispensed. Trust me the product is awesome. Have a nice day.");
    }
}
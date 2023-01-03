package state;

import vendingmachine.VendingMachine;

public class InitialState implements State {

    private VendingMachine vendingMachine;

    public InitialState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pay(int amount) {
        vendingMachine.setBalance(vendingMachine.getBalance() + amount);
        System.out.println(
                "You have paid " + amount + " taka. Your current balance is " + vendingMachine.getBalance()
                        + " taka. Product price is "
                        + vendingMachine.getPrice() + " taka.");

        if (vendingMachine.getBalance() > vendingMachine.getPrice()) {
            vendingMachine.setState(vendingMachine.getOverpaidState());
        } else if (vendingMachine.getBalance() == vendingMachine.getPrice()) {
            vendingMachine.setState(vendingMachine.getSoldState());
        } else {
            vendingMachine.setState(vendingMachine.getUnderpaidState());
        }
    }

    @Override
    public void returnMoney() {
        System.out.println("No money to return.");
    }

    @Override
    public void dispense() {
        System.out.println("No product to dispense.");
    }

}
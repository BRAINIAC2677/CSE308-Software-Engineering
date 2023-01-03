package state;

import vendingmachine.VendingMachine;

public class UnderpaidState implements State {

    VendingMachine vendingMachine;

    public UnderpaidState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pay(int amount) {
        vendingMachine.setBalance(amount + vendingMachine.getBalance());
        System.out.println(
                "You have paid " + amount + " taka. Your current balance is " + vendingMachine.getBalance()
                        + " taka. Product price is "
                        + vendingMachine.getPrice() + " taka.");

        if (vendingMachine.getBalance() > vendingMachine.getPrice()) {
            vendingMachine.setState(vendingMachine.getOverpaidState());
        } else if (vendingMachine.getBalance() == vendingMachine.getPrice()) {
            vendingMachine.setState(vendingMachine.getSoldState());
        }
    }

    @Override
    public void returnMoney() {
        System.out.println("No money to return.");
    }

    @Override
    public void dispense() {
        System.out.println(
                "No product to dispense. Please pay " + (vendingMachine.getPrice() - vendingMachine.getBalance())
                        + " taka more.");
    }
}
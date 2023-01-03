package vendingmachine;

import state.*;

public class VendingMachine {
    int quantity;
    int price;
    int balance;

    State InitialState;
    State UnderpaidState;
    State OverpaidState;
    State SoldState;
    State StockoutState;

    State state;

    public VendingMachine(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
        this.balance = 0;

        InitialState = new InitialState(this);
        UnderpaidState = new UnderpaidState(this);
        OverpaidState = new OverpaidState(this);
        SoldState = new SoldState(this);
        StockoutState = new StockoutState(this);

        state = InitialState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pay(int amount) {
        state.pay(amount);
        state.returnMoney();
        state.dispense();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public State getInitialState() {
        return InitialState;
    }

    public State getUnderpaidState() {
        return UnderpaidState;
    }

    public State getOverpaidState() {
        return OverpaidState;
    }

    public State getSoldState() {
        return SoldState;
    }

    public State getStockoutState() {
        return StockoutState;
    }

    public State getState() {
        return state;
    }
}

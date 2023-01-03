package state;

public interface State {

    public void pay(int amount);

    public void returnMoney();

    public void dispense();
}
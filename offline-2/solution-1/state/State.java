package state;

public interface State {

    public void changeToOperational();

    public void changeToPartiallyDown();

    public void changeToFullyDown();
}
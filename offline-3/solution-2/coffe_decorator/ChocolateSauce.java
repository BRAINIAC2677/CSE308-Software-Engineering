package coffe_decorator;

import coffe.*;

public class ChocolateSauce extends CoffeDecorator {
    private Coffe wrapped_coffe;

    public ChocolateSauce(Coffe _wrapped_coffe) {
        super();
        this.wrapped_coffe = _wrapped_coffe;
    }

    @Override
    public void print_ingredients() {
        this.wrapped_coffe.print_ingredients();
        System.out.println("chocolate sauce");
    }

    @Override
    public int get_cost() {
        return this.wrapped_coffe.get_cost() + 60;
    }
}
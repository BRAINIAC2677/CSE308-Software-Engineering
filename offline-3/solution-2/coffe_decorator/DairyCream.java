package coffe_decorator;

import coffe.*;

public class DairyCream extends CoffeDecorator {
    private Coffe wrapped_coffe;

    public DairyCream(Coffe _wrapped_coffe) {
        super();
        this.wrapped_coffe = _wrapped_coffe;
    }

    @Override
    public void print_ingredients() {
        this.wrapped_coffe.print_ingredients();
        System.out.println("dairy cream");
    }

    @Override
    public int get_cost() {
        return this.wrapped_coffe.get_cost() + 40;
    }
}
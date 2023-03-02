package decorator;

import component.*;

public class UnicornHorn extends Decorator {
    public UnicornHorn(Component wrapped_component) {
        this.wrapped_component = wrapped_component;
        this.ingredients = this.wrapped_component.get_ingredients();
        this.ingredients.add("Unicorn Horn");
        this.cost = 6.31 * 2.5 + this.wrapped_component.get_cost();
        this.penalty_points = 2 * 25 + this.wrapped_component.get_penalty_points();
    }
}
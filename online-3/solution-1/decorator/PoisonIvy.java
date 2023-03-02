package decorator;

import component.*;

public class PoisonIvy extends Decorator {
    public PoisonIvy(Component wrapped_component) {
        this.wrapped_component = wrapped_component;
        this.ingredients = this.wrapped_component.get_ingredients();
        this.ingredients.add("poison ivy");
        this.cost = 3.38 * 2.5 + this.wrapped_component.get_cost();
        this.penalty_points = 2 * 25 + this.wrapped_component.get_penalty_points();
    }
}
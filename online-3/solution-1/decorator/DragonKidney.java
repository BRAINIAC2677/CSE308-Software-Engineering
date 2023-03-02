package decorator;

import component.*;

public class DragonKidney extends Decorator {
    public DragonKidney(Component wrapped_component) {
        this.wrapped_component = wrapped_component;
        this.ingredients = this.wrapped_component.get_ingredients();
        this.ingredients.add("dragon kidney");
        this.cost = 5.86 * 2.5 + this.wrapped_component.get_cost();
        this.penalty_points = 2 * 25 + this.wrapped_component.get_penalty_points();
    }
}
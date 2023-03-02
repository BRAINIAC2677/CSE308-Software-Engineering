package decorator;

import component.*;

public class ChineseChomping extends Decorator {
    public ChineseChomping(Component wrapped_component) {
        this.wrapped_component = wrapped_component;
        this.ingredients = this.wrapped_component.get_ingredients();
        this.ingredients.add("Chinese chomping");
        this.cost = 4.13 * 2.5 + this.wrapped_component.get_cost();
        this.penalty_points = 2 * 25 + this.wrapped_component.get_penalty_points();
    }
}
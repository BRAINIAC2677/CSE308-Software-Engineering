package component;

import java.util.ArrayList;

public abstract class Component {
    protected double cost;
    protected int penalty_points;
    protected ArrayList<String> ingredients;

    public Component() {
        this.ingredients = new ArrayList<String>();
    }

    public double get_cost() {
        return this.cost;
    }

    public int get_penalty_points() {
        return this.penalty_points;
    }

    public ArrayList<String> get_ingredients() {
        return this.ingredients;
    }

    public void show() {
        System.out.println("Cost: " + this.cost);
        System.out.println("Penalty points: " + this.penalty_points);
        for (String ingredient : this.ingredients) {
            System.out.println(ingredient);
        }
    }

}
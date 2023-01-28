package coffe;

import java.util.ArrayList;

public abstract class Coffe {
    protected ArrayList<String> ingredients;

    public Coffe() {
        this.ingredients = new ArrayList<String>();
    }

    public void print_ingredients() {
        for (String ingredient : this.ingredients) {
            System.out.println(ingredient);
        }
    }

    public abstract int get_cost();
}
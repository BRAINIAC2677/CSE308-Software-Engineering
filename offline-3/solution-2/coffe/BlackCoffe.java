package coffe;

public class BlackCoffe extends Coffe {
    public BlackCoffe() {
        super();
        this.ingredients.add("grinded coffee beans");
        this.ingredients.add("water");
    }

    @Override
    public int get_cost() {
        return 100 + 30;
    }
}
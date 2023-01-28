package coffe;

public class MilkCoffe extends Coffe {
    public MilkCoffe() {
        super();
        this.ingredients.add("grinded coffee beans");
        this.ingredients.add("milk");
    }

    @Override
    public int get_cost() {
        return 100 + 30 + 50;
    }
}
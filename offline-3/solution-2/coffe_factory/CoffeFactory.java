package coffe_factory;

import coffe.*;
import coffe_decorator.*;

public class CoffeFactory {

    public Coffe make_coffe(CoffeVariant variant) {
        Coffe coffe = null;
        switch (variant) {
            case Americano: {
                coffe = new BlackCoffe();
                coffe = new GrindedCoffe(coffe);
                break;
            }
            case Espresso: {
                coffe = new BlackCoffe();
                coffe = new DairyCream(coffe);
                break;
            }
            case Cappuccino: {
                coffe = new MilkCoffe();
                coffe = new CinnamonPowder(coffe);
                break;
            }
            case Mocha: {
                coffe = new MilkCoffe();
                coffe = new ChocolateSauce(coffe);
                break;
            }
        }
        return coffe;
    }
}
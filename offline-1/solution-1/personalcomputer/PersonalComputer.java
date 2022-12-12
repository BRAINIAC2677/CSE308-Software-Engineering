package personalcomputer;

import java.util.List;
import java.util.ArrayList;

import component.*;
import component.motherboard.*;
import component.storage.*;
import component.cpu.*;

public class PersonalComputer {
    private double base_price;
    private double added_price;
    private List<Component> base_components;
    private List<Component> added_components;

    public PersonalComputer() {
        base_components = new ArrayList<Component>();
        added_components = new ArrayList<Component>();
        base_components.add(new CPU());
        base_components.add(new Motherboard());
        base_components.add(new HDD());
        base_price = 70000;
    }

    public void addComponent(Component component) {
        added_components.add(component);
        added_price += component.getPrice();
    }

    public void show() {
        System.out.println("Total price: " + getTotalPrice());
        System.out.println();
        System.out.println("Base price: " + base_price);
        showBaseComponents();
        System.out.println();
        System.out.println("Added price: " + added_price);
        showAddedComponents();
    }

    public void showBaseComponents() {
        System.out.println("Base Components:");
        for (Component component : base_components) {
            System.out.println(component);
        }
    }

    public void showAddedComponents() {
        System.out.println("Added Components:");
        for (Component component : added_components) {
            System.out.println(component);
        }
    }

    public double getTotalPrice() {
        return base_price + added_price;
    }

}
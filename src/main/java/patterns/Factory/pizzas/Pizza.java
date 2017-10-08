package patterns.Factory.pizzas;


import patterns.Factory.ingredientfactories.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStoreBox");
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public Sauce getSauce() {
        return sauce;
    }
}

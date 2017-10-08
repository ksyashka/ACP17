package patterns.Factory;

import patterns.Factory.ingredientfactories.NYPizzaIngredientFactory;
import patterns.Factory.ingredientfactories.PizzaIngredientFactory;
import patterns.Factory.pizzas.*;

public class NYPizzaStore extends PizzaStore {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            return new CheesePizza(ingredientFactory);
        }
        else if (type.equals("pepperoni"))
            return new PepperoniPizza();
        else if (type.equals("clam"))
            return new ClamPizza(ingredientFactory);
        else if (type.equals("veggie"))
            return new VeggiePizza();

        return null;
    }
}

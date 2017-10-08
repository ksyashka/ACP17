package patterns.Factory;

import patterns.Factory.pizzas.*;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese"))
            return new ChicagoStyleCheesePizza();
        else if (type.equals("pepperoni"))
            return new PepperoniPizza();
      //  else if (type.equals("clam"))
      //      return new ClamPizza();
        else if (type.equals("veggie"))
            return new VeggiePizza();

        return null;
    }
}

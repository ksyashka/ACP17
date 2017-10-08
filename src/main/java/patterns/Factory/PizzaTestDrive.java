package patterns.Factory;

import patterns.Factory.pizzas.Pizza;

public class PizzaTestDrive {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        pizza = chicagoStore.orderPizza("cheese");
    }
}

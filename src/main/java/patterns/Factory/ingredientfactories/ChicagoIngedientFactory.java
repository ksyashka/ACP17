package patterns.Factory.ingredientfactories;

public class ChicagoIngedientFactory implements PizzaIngredientFactory {
    public Dough createDough(){
        return new ThickCrustDough();
    }

    public Sauce createSauce(){
        return new PlumTomatoSauce();
    }

    public Cheese createCheese(){
        return new Mozzarella();
    }

    public Pepperoni createPepperoni(){
        return new SlicedPepperoni();
    }

    public Clams createClam(){
        return new FrozenClams();
    }
}

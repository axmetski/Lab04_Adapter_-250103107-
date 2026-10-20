
interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Dough & Sauce";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0; 
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}

class Pineapple extends PizzaDecorator {
    public Pineapple(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Pineapple";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza myPizza = new Cheese(new Olives(new Pineapple(new PlainPizza())));

        System.out.println("Description: " + myPizza.getDescription());
        System.out.println("Total Cost: $" + myPizza.getCost());
    }
}

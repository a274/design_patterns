package com.company;

/**
 * Implementation of Abstract Factory.
 * Each type of product is produced by its certain factory.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        IceCreamFactory bananaIceCreamFactory = new BananaIceCreamFactory();
        IceCreamFactory strawberryIceCreamFactory = new StrawberryIceCreamFactory();

        makeUpDialog("banana", bananaIceCreamFactory);
        makeUpDialog("strawberry", strawberryIceCreamFactory);
    }

    /**
     * method for making a dialog
     * @param flavor ice cream flavor
     * @param factory ice cream factory
     */
    public static void makeUpDialog(String flavor, IceCreamFactory factory) throws InterruptedException {
        System.out.println("-Good day. I would like a " + flavor + " ice cream , please");
        System.out.println("-Got It! Give me a sec.");
        Thread.sleep(5000);

        IceCream iceCream = factory.makeIceCream();
        IceCreamIngredients ingredients = factory.makeIceCreamIngredients();

        System.out.println(iceCream.getIceCream() + "\n" + ingredients.getIngredients());
        System.out.println("-Here you go!\n");
        Thread.sleep(5000);
    }
}

/**
 * Abstract product
 */
interface IceCream {
    String getIceCream();
}

/**
 * Concrete product A
 */
class BananaIceCream implements IceCream {
    @Override
    public String getIceCream() {
        return "There is a banana ice cream";
    }
}

/**
 * Concrete product B
 */
class StrawberryIceCream implements IceCream {
    @Override
    public String getIceCream() {
        return "There is a strawberry ice cream";
    }
}

interface IceCreamIngredients {
    String getIngredients();
}

class BananaIceCreamIngredients implements IceCreamIngredients {
    @Override
    public String getIngredients() {
        return "These is banana topping and an ice cream cone.";
    }
}

class StrawberryIceCreamIngredients implements IceCreamIngredients {
    @Override
    public String getIngredients() {
        return "These is strawberry topping and an ice cream cone.";
    }
}

/**
 * Abstract factory
 */
interface IceCreamFactory {
    IceCream makeIceCream();

    IceCreamIngredients makeIceCreamIngredients();
}

/**
 * Concrete factory A
 */
class BananaIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream makeIceCream() {
        return new BananaIceCream();
    }

    @Override
    public IceCreamIngredients makeIceCreamIngredients() {
        return new BananaIceCreamIngredients();
    }
}
/**
 * Concrete factory B
 */
class StrawberryIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream makeIceCream() {
        return new StrawberryIceCream();
    }

    @Override
    public IceCreamIngredients makeIceCreamIngredients() {
        return new StrawberryIceCreamIngredients();
    }
}
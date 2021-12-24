package com.company;

/**
 * Implementation of Factory method.
 * Several types of products are produced by one Factory.
 */
class Main {
    public static void main(String[] args) throws InterruptedException {
        BurgerStore burgerStore = new BurgerStore();

        Burger burger = burgerStore.orderBurger("ChineseBurger");
        burger = burgerStore.orderBurger("AmericanBurger");
        burger = burgerStore.orderBurger("RussianBurger");
    }
}

/**
 * Creator.
 */
abstract class BurgerFactory {

    /**
     * factoryMethod.
     */
    abstract Burger createBurger(String type);

    /**
     * anOperator.
     */
    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are not able to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println("Done a " + burger.getName() + "\n");
        return burger;
    }
}

/**
 * Concrete Creator.
 */
class BurgerStore extends BurgerFactory {
    /**
     * factoryMethod.
     */
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "ChineseBurger":
                return new ChineseBurger("Chinese Burger");
            case "AmericanBurger":
                return new AmericanBurger("American Burger");
            case "RussianBurger":
                return new RussianBurger("Russian Burger");
            default:
                return null;
        }
    }
}

/**
 * Product.
 */
abstract class Burger {
    private final String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting cutlet");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

/**
 * Concrete products.
 */
class ChineseBurger extends Burger {

    public ChineseBurger(String name) {
        super(name);
    }

    String getName() {
        return super.getName();
    }
}

class AmericanBurger extends Burger {
    public AmericanBurger(String name) {
        super(name);
    }

    String getName() {
        return super.getName();
    }
}

class RussianBurger extends Burger {
    public RussianBurger(String name) {
        super(name);
    }

    String getName() {
        return super.getName();
    }
}
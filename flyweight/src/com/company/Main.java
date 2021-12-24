package com.company;

import java.util.ArrayList;

/**
 * Implementation of Flyweight Pattern.
 */
public class Main {

    public static void main(String[] args) {
        CookieFactory packet = new CookieFactory();
        packet.produceCookies(5, "Coconut");
        packet.open();
        packet.eatAllCookies();
        packet.putOutCookie();

        packet.produceCookies(3, "Chocolate");
        packet.open();
        CookieWithFlavor cookie = packet.putOutCookie();
        cookie.getInfo();
        cookie.eat();

        CookieFactory anotherPacket = new CookieFactory();
        anotherPacket.open();
    }
}

/**
 * Concrete Flyweight
 */
class Cookie {
    private final int weight = 10;
    private final String shape = "round";
    private final String[] ingredients = {"flour", "sugar", "eggs", "butter", "salt"};

    private static final Cookie instance = new Cookie();

    public static Cookie getInstance() {
        return instance;
    }

    private Cookie() {
    }

    public int getWeight() {
        return weight;
    }

    public String getShape() {
        return shape;
    }

    public String[] getIngredients() {
        return ingredients;
    }
}

/**
 * Unshared Concrete Flyweight
 */
class CookieWithFlavor {
    private final String flavor;
    public Cookie cookie = Cookie.getInstance();

    public CookieWithFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void eat() {
        System.out.println(flavor + " cookie is eaten.");
    }

    public void cook() {
        System.out.println(flavor + " cookie is cooked");
    }

    public void getInfo() {
        System.out.printf("This cookie is %d gram weight, %s-shaped, consists of following ingredients:\n%s, %s, %s, %s, %s\n",
                cookie.getWeight(), cookie.getShape(), cookie.getIngredients()[0],
                cookie.getIngredients()[1], cookie.getIngredients()[2],
                cookie.getIngredients()[3], cookie.getIngredients()[4]);
    }

}

/**
 * Flyweight Factory
 */
class CookieFactory {
    private ArrayList<CookieWithFlavor> packetOfCookies;

    public ArrayList produceCookies(int number, String flavor) {
        packetOfCookies = new ArrayList();
        for (int i = 0; i < number; i++) {
            CookieWithFlavor cookieWithFlavor = new CookieWithFlavor(flavor);
            cookieWithFlavor.cook();
            packetOfCookies.add(cookieWithFlavor);
        }
        return packetOfCookies;
    }

    public void open() {
        if (packetOfCookies != null)
            System.out.println("A packet of " + packetOfCookies.get(0).getFlavor() + " cookies is being opened.");
        else
            System.out.println("There is no packet of cookies nearby!");
    }

    public CookieWithFlavor putOutCookie() {
        CookieWithFlavor cookie = null;
        if (packetOfCookies.size() > 0) {
            cookie = packetOfCookies.remove(packetOfCookies.size() - 1);
        } else System.out.println("There are no cookies left! :(");
        return cookie;
    }

    public void eatAllCookies() {
        if (packetOfCookies.size() > 0) {
            for (CookieWithFlavor packetOfCookie : packetOfCookies)
                packetOfCookie.eat();
        } else System.out.println("There are no cookies left!");
    }
}



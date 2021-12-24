package com.company;

/**
 * Implementation of Prototype Pattern.
 * An object is created by supporting class with the only properties that are needed.
 */


class Cookie implements Cloneable{
    /**
     * Prototype class
     */
    public String getName() {
        return "Cookie";
    }

    @Override
    public Cookie clone() throws CloneNotSupportedException {
        return (Cookie) super.clone();
    }
}

/**
 * Concrete Prototypes to clone
 */
class CoconutCookie extends Cookie {
    public String getName() {
        return "Coconut Cookie";
    }


}

class ChocolateCookie extends Cookie {
    public String getName() {
        return "Chocolate Cookie";
    }
}

/**
 * Client Class
 */
class CookieMachine {

    private Cookie cookie;

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie makeCookie() throws CloneNotSupportedException, InterruptedException {
        System.out.println(cookie.getName() + " was made!");
        Thread.sleep(200);
        return this.cookie.clone();
    }
}

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        Cookie[] packetOfCoconutCookies = new Cookie[5];
        Cookie[] packetOfChocolateCookies = new Cookie[5];

        Cookie prototype1 = new CoconutCookie();
        Cookie prototype2 = new ChocolateCookie();
        CookieMachine cm = new CookieMachine();

        cm.setCookie(prototype1);
        for (int i = 0; i < 5; i++)
            packetOfCoconutCookies[i] =  cm.makeCookie();
        System.out.println("A packet of Coconut Cookies was made!\n");

        cm.setCookie(prototype2);
        for (int i = 0; i < 5; i++)
            packetOfChocolateCookies[i] =  cm.makeCookie();
        System.out.println("A packet of Chocolate Cookies was made!\n");
    }
}

package com.company;

import java.util.ArrayList;

/**
 * Implementation of Composite pattern
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Package myPackage = new Package();
        myPackage.pack();
        myPackage.getPackageInfo();
        myPackage.deliver();
        myPackage.unpack();
    }
}

class Package {
    private final Composite myPackage;

    public Package() {
        myPackage = new Composite();
    }

    public void pack() {
        Leaf receipt = new Leaf("receipt");
        Leaf hammer = new Leaf("hammer");
        Leaf phone = new Leaf("phone");
        Leaf headset = new Leaf("headset");
        Leaf charger = new Leaf("charger");
        myPackage.add(receipt);

        Composite package1 = new Composite();
        package1.add(hammer);
        myPackage.add(package1);

        Composite package2 = new Composite();

        Composite package3 = new Composite();
        package3.add(phone);
        package3.add(headset);

        Composite package4 = new Composite();
        package4.add(charger);

        package2.add(package3);
        package2.add(package4);
        myPackage.add(package2);
    }

    public void getPackageInfo() {
        System.out.println("Your package include: ");
        for (Component c : myPackage.getChildren()) {
            System.out.println("\t-" + ((Leaf) c).getName());
        }
    }

    public void deliver() throws InterruptedException {
        System.out.println("\nThe package is being delivered..");
        Thread.sleep(400);
        System.out.println("The package is delivered!\n");
    }

    public void unpack() throws InterruptedException {
        myPackage.execute();
    }
}

interface Component {
    void execute() throws InterruptedException;
}

class Composite implements Component {
    private final ArrayList<Component> children;

    public Composite() {
        this.children = new ArrayList<>();
    }

    public void add(Component c) {
        children.add(c);
    }

    public void remove(Component c) {
        children.remove(c);
    }

    private ArrayList<Component> allChildren = new ArrayList<>();

    private void getChildren(Component c) {
        if (c instanceof Leaf && !allChildren.contains(c)) allChildren.add(c);
        else if (c instanceof Composite) getChildren(((Composite) c).children);
    }

    private void getChildren(ArrayList<Component> arr) {
        for (Component c : arr) {
            getChildren(c);
        }
    }

    public ArrayList<Component> getChildren() {
        getChildren(this);
        ArrayList<Component> all = allChildren;
        allChildren = new ArrayList<>();
        return all;
    }

    private void execute(Component c) throws InterruptedException {
        if (c instanceof Leaf && !allChildren.contains(c)) {
            allChildren.add(c);
            c.execute();
        } else if (c instanceof Composite) {
            System.out.println("unpacking a package..");
            Thread.sleep(400);
            execute(((Composite) c).children);
        }
    }

    private void execute(ArrayList<Component> arr) throws InterruptedException {
        for (Component c : arr) {
            execute(c);
        }
    }

    @Override
    public void execute() throws InterruptedException {
        execute(this);
    }
}

class Leaf implements Component {
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println("putting out a " + name);
    }
}
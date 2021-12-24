package com.company.move;

/**
 * Client
 */
public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        invoker.setCommand(new Back(receiver, new Wolf()))
                .executeCommand();
        invoker.setCommand(new Left(receiver, new Fox()))
                .executeCommand();
        invoker.setCommand(new Forward(receiver, new Bear()))
                .executeCommand();
        invoker.setCommand(new Right(receiver, new Fox()))
                .executeCommand();
    }
}

/**
 * Supporting classes
 */
class Animal {
    protected String name;
    @Override
    public String toString() {
        return name;
    }
}

class Bear extends Animal {
    public Bear() {
        name = "Bear";
    }
}

class Fox extends Animal {
    public Fox() {
        name = "Fox";
    }
}

class Wolf extends Animal {
    public Wolf() {
        name = "Wolf";
    }
}

interface Command {
    void execute();
}

/**
 * Command 1
 */
class Forward implements Command {
    private final Receiver receiver;
    private final Animal animal;

    public Forward(Receiver receiver, Animal animal) {
        this.receiver = receiver;
        this.animal = animal;
    }

    @Override
    public void execute() {
        System.out.println(animal + " moving forward...");
        receiver.action(animal);
    }
}

/**
 * Command 2
 */
class Back implements Command {
    private final Receiver receiver;
    private final Animal animal;

    public Back(Receiver receiver, Animal animal) {
        this.receiver = receiver;
        this.animal = animal;
    }

    @Override
    public void execute() {
        System.out.println(animal + " moving back...");
        receiver.action(animal);
    }
}

/**
 * Command 3
 */
class Left implements Command {
    private final Receiver receiver;
    private final Animal animal;

    public Left(Receiver receiver, Animal animal) {
        this.receiver = receiver;
        this.animal = animal;
    }

    @Override
    public void execute() {
        System.out.println(animal + " moving left...");
        receiver.action(animal);
    }
}

/**
 * Command 4
 */
class Right implements Command {
    private final Receiver receiver;
    private final Animal animal;

    public Right(Receiver receiver, Animal animal) {
        this.receiver = receiver;
        this.animal = animal;
    }

    @Override
    public void execute() {
        System.out.println(animal + " moving right...");
        receiver.action(animal);
    }
}

class Invoker {
    private Command command;

    public Invoker setCommand(Command command) {
        this.command = command;
        return this;
    }

    public void executeCommand() {
        command.execute();
    }
}

class Receiver {
    public void action(Animal animal) {
        System.out.println(animal + " changed location.");
    }
}

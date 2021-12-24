package com.company.calculate;

public class Main {

    public static void main(String[] args) {
        double a = 10;
        double b = 5;

	    Invoker invoker = new Invoker();
	    Receiver receiver = new Receiver();
        invoker.setCommand(new Add(receiver, a, b))
                .executeCommand();
        System.out.printf("The result of adding %.1f and %.1f is %.1f%n", a, b, receiver.getResult());

        a = receiver.getResult();
        invoker.setCommand(new Multiply(receiver, a, b))
                .executeCommand();
        System.out.printf("The result of multiplying %.1f and %.1f is %.1f%n", a, b, receiver.getResult());

        a = receiver.getResult();
        invoker.setCommand(new Sqrt(receiver, a))
                .executeCommand();
        System.out.printf("The result of extracting the root of %.1f is %.1f%n", a, receiver.getResult());

        a = receiver.getResult();
        invoker.setCommand(new Divide(receiver, a, b))
                .executeCommand();
        System.out.printf("The result of dividing %.1f and %.1f is %.1f%n", a, b, receiver.getResult());

        a = receiver.getResult();
        invoker.setCommand(new Subtract(receiver, a, b))
                .executeCommand();
        System.out.printf("The result of subtracting %.1f and %.1f is %.1f%n", a, b, receiver.getResult());
    }
}

interface Command {
    void execute();
}

class Add implements Command {
    private final Receiver receiver;
    private final double a;
    private final double b;

    public Add(Receiver receiver, double a, double b) {
        this.receiver = receiver;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        receiver.operation(a + b);
    }
}

class Subtract implements Command {
    private final Receiver receiver;
    private final double a;
    private final double b;

    public Subtract(Receiver receiver, double a, double b) {
        this.receiver = receiver;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        receiver.operation(a - b);
    }
}

class Multiply implements Command {
    private final Receiver receiver;
    private final double a;
    private final double b;

    public Multiply(Receiver receiver, double a, double b) {
        this.receiver = receiver;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        receiver.operation(a * b);
    }
}

class Sqrt implements Command {
    private final Receiver receiver;
    private final double a;

    public Sqrt(Receiver receiver, double a) {
        this.receiver = receiver;
        this.a = a;
    }

    @Override
    public void execute() {
        receiver.operation(Math.sqrt(a));
    }
}

class Divide implements Command {
    private final Receiver receiver;
    private final double a;
    private final double b;

    public Divide(Receiver receiver, double a, double b) {
        this.receiver = receiver;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        receiver.operation(a / b);
    }
}

class Receiver {
    private double result;

    public double getResult() {
        return result;
    }

    public void operation(double res) {
        result = res;
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
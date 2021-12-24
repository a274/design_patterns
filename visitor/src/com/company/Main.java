package com.company;

/**
 * Implementation of Visitor pattern
 */
public class Main {

    public static void main(String[] args) {
        Expression expression = new BinaryOperation(new Number(4.5), '*', new BinaryOperation(new Number(2.22), '+', new Number(3.76)));
        PrintVisitor visitor = new PrintVisitor();
        expression.visit(visitor);
    }
}


interface Visitor {
    void visitNumber(Number number);

    void visitBinaryOperation(BinaryOperation operation);
}

/**
 * Element
 */
abstract class Expression {
    abstract double evaluate();

    abstract void visit(Visitor visitor);
}

/**
 * Concrete Element A
 */
class Number extends Expression {
    private final double value;

    public Number(double value) {
        this.value = value;
    }

    public double evaluate() {
        return value;
    }


    public double getValue() {
        return value;
    }

    public void visit(Visitor visitor) {
        visitor.visitNumber(this);
    }
}

/**
 * Concrete Element B
 */
class BinaryOperation extends Expression {
    private final Expression left;
    private final Expression right;
    private final char op;

    public BinaryOperation(Expression left, char op, Expression right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public double evaluate() {
        if (op == '+') return left.evaluate() + right.evaluate();
        if (op == '-') return left.evaluate() - right.evaluate();
        if (op == '*') return left.evaluate() * right.evaluate();
        if (op == '/') return left.evaluate() / right.evaluate();
        return 0;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public char getOp() {
        return op;
    }

    public void visit(Visitor visitor) {
        visitor.visitBinaryOperation(this);
    }
}

/**
 * Concrete Visitor
 */
class PrintVisitor implements Visitor {
    public void visitNumber(Number number) {
        System.out.print(number.getValue());
    }

    public void visitBinaryOperation(BinaryOperation bop) {
        System.out.print("(");
        bop.getLeft().visit(this);
        System.out.print(" " + bop.getOp() + " ");
        bop.getRight().visit(this);
        System.out.print(")");
    }
}
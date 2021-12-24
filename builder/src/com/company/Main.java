package com.company;

/**
 * Implementation of Builder Pattern.
 * An object is created by supporting class with the only properties that are needed.
 */

class Sandwich {
    private final String bun;
    private final int salad;
    private final int cheese;
    private final int cucumber;
    private final int ham;

    public Sandwich(String bun, int salad, int cheese, int cucumber, int ham) {
        this.bun = bun;
        this.salad = salad;
        this.cheese = cheese;
        this.cucumber = cucumber;
        this.ham = ham;
    }

    public static class Builder {

        private String bun;
        private int salad;
        private int cheese;
        private int cucumber;
        private int ham;

        public Builder addBun(String bun) {
            this.bun = bun;
            return this;
        }

        public Builder addSalad(int salad) {
            this.salad = salad;
            return this;
        }

        public Builder addCheese(int cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder addCucumber(int cucumber) {
            this.cucumber = cucumber;
            return this;
        }

        public Builder addHam(int ham) {
            this.ham = ham;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(bun, salad, cheese, cucumber, ham);
        }
    }

    @Override
    public String toString() {
        String str = "";
        if (bun != null) {
            str += "Bun : " + bun + "\n";
        }
        if (salad != 0) {
            str += "Salad : " + salad + "\n";
        }
        if (cheese != 0) {
            str += "Cheese : " + cheese + "\n";
        }
        if (cucumber != 0) {
            str += "Cucumber : " + cucumber + "\n";
        }
        if (ham != 0) {
            str += "Ham : " + ham + "\n";
        }
        return str;
    }
}

/**
 * Director.
 */
class Main {
    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich.Builder()
                .addBun("Italian")
                .addSalad(3)
                .addCheese(3)
                .addCucumber(4)
                .addHam(5)
                .build();
        System.out.println(sandwich);

        sandwich = new Sandwich.Builder()
                .addBun("Garlic")
                .addHam(5).build();
        System.out.println(sandwich);
    }
}

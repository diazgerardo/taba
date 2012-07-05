package ar.com.scriptorum.patterns.decorator;


class Decorator {
    public Decorator() {
        System.out.print("Random number: ");//add a description to the number printed
        new Number().print();
    }
}

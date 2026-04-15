package com.naresh.b_concepts.inheritence.vs.composition;

public class Runner {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Example ===");
        InheritanceExample.Dog dog1 = new InheritanceExample.Dog();
        dog1.speak();
        dog1.fetch();

        System.out.println("\n=== Composition Example ===");
        CompositionExample.Tail tail = new CompositionExample.Tail(20);
        CompositionExample.SoundBehavior bark = new CompositionExample.Bark();
        CompositionExample.Dog dog2 = new CompositionExample.Dog(tail, bark);
        dog2.speak();
        dog2.wagTail();
    }
}


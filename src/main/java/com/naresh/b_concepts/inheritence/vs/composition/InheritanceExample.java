package com.naresh.b_concepts.inheritence.vs.composition;

/**
 * Simple inheritance example: Dog "is-a" Animal.
 */
public class InheritanceExample {
    static class Animal {
        public void speak() { System.out.println("Animal speaks"); }
    }

    static class Dog extends Animal {
        @Override
        public void speak() { System.out.println("Dog barks"); }
        public void fetch() { System.out.println("Dog fetches"); }
    }
}


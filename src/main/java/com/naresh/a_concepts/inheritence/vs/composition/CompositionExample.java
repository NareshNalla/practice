package com.naresh.a_concepts.inheritence.vs.composition;

/**
 * Simple composition example: Dog has-a Tail (composition), and has-a SoundBehavior strategy.
 */
public class CompositionExample {
    static class Tail {
        private final int lengthCm;
        Tail(int lengthCm) { this.lengthCm = lengthCm; }
        public void wag() { System.out.println("Tail wags (" + lengthCm + "cm)"); }
    }

    interface SoundBehavior { void makeSound(); }
    static class Bark implements SoundBehavior { public void makeSound() { System.out.println("Bark!"); } }

    static class Dog {
        private final Tail tail;          // composition: Dog HAS-A Tail
        private final SoundBehavior sound;
        public Dog(Tail tail, SoundBehavior sound) {
            this.tail = tail;
            this.sound = sound;
        }
        public void speak() { sound.makeSound(); }
        public void wagTail() { tail.wag(); }
    }
}


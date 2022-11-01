package Other;

import Interfaces.Learn;

public class Dog extends Animal implements Learn {

    public Dog(String name, int age) {
        super(name, age);
    }

    public void remember() {
        System.out.println(this.getClass().getSimpleName() + " can remember for 5 minutes");
    }

    public void protectOwner() {
        System.out.println(this.getClass().getSimpleName() + " will protect owner");
    }

    public void learn() {
        System.out.println(this.getClass().getSimpleName() + " can learn:");
    }
}
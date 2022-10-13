import Interfaces.Climb;

/**
 * Implements a container of fuctions
 *
 * Extends a parent class
 */
public class Cat extends Animal implements Climb {


    public Cat(String name, int age) {
        super(name, age);
    }

    public void remember() {
        System.out.println(this.getClass().getSimpleName() + " can remember for 16 hours");
    }

    public void protectOwner() {
        System.out.println(this.getClass().getSimpleName() + " won't protect owner");
    }

    public void climb() {
        System.out.println(this.getClass().getSimpleName() + " can climb");
    }
}

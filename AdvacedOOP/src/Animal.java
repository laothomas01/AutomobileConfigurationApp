/**
 * Abstract vs Interface
 * ____________________
 * similarities:
 * - both have abstract methods
 * - share properties of inheritance
 * differences:
 * Abstract:
 * - when a class needs to inherit attributes from another class
 * - can define more non-abstract methods inside abstract class without forcing implementation
 * Interface:
 * - build a singular relationship between closely related classes
 * - forces a contract of implementation for implementing class
 *
 * What about an abstract class implementing an interface?
 *
 */
abstract public class Animal {
    String name;
    int lifeExpentency;

    public Animal(String name, int lifeExpentency) {
        this.name = name;
        this.lifeExpentency = lifeExpentency;
    }

    /**
     * What makes these methods different than those form an interface??
     * - these methods are as abstract as the ones defined in the interface
     */
    public abstract void remember();

    public abstract void protectOwner();

    public String toString() {
        return this.getClass().getSimpleName() + ":" + name + ":" + lifeExpentency;
    }

}


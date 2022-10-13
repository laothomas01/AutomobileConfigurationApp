import Interfaces.*;

/**
 * Key Notes:
 * <p>
 * Animal is an abstract class with:
 * SHARED attributes:
 * -name
 * -lifeExpectancy
 * Abstract methods:
 * -remember()
 * -protectOwner()
 * <p>
 * Dog and Cat ARE Animals implement remember() and protectOwner()
 *
 * Cat can climb() but Dog cannot.
 *
 * Dog can think() but Cat cannot.
 *
 *
 * Unrelated classes can have capabilities through interfaces.
 *
 * Related classes change the behavior through extension of base classes
 *
 * Consider using abstract classes if.....
 * 1) You want to share code among several closely related classes
 * 2) expect that classes extending your abstract class have:
 *  many common methods
 *  or fields
 *  or require access modifiers other than public(such as protected and private)
 * 3) You want to declare non-static or non-final fields
 * Consider using interfaces if.....
 * 1) Unrelated classes would implement your interface.
 *  ex: look at Serializable
 * 2) You want to specify the behaviour of a particular data type but not concerned with who implements the behavior
 * 3) Take advantage of multiple inheritance of type.
 *
 */
public class Driver {
    public static void main(String args[]) {
        Dog dog = new Dog("Jack", 16);
        Cat cat = new Cat("Joe", 20);

        System.out.println("Dog:" + dog);
        System.out.println("Cat:" + cat);

        dog.remember();
        dog.protectOwner();
        Learn dl = dog;
        dl.learn();

        cat.remember();
        cat.protectOwner();

        Climb c = cat;
        c.climb();

        Man man = new Man("Ravindra", 40);
        System.out.println(man);

        Climb cm = man;
        cm.climb();
        Think t = man;
        t.think();
        Learn l = man;
        l.learn();
        Apply a = man;
        a.apply();

    }
}

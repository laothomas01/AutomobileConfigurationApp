import Interfaces.*;

import java.io.File;
import java.util.Scanner;

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
 * <p>
 * Cat can climb() but Dog cannot.
 * <p>
 * Dog can think() but Cat cannot.
 * <p>
 * <p>
 * Unrelated classes can have capabilities through interfaces.
 * <p>
 * Related classes change the behavior through extension of base classes
 * <p>
 * Consider using abstract classes if.....
 * 1) You want to share code among several closely related classes
 * 2) expect that classes extending your abstract class have:
 * many common methods
 * or fields
 * or require access modifiers other than public(such as protected and private)
 * 3) You want to declare non-static or non-final fields
 * Consider using interfaces if.....
 * 1) Unrelated classes would implement your interface.
 * ex: look at Serializable
 * 2) You want to specify the behaviour of a particular data type but not concerned with who implements the behavior
 * 3) Take advantage of multiple inheritance of type.
 */
public class Driver {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file to be searched.. ");
        String name = scan.next();
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        Driver.findFile(name, new File(directory));
//        Dog dog = new Dog("Jack", 16);
//        Cat cat = new Cat("Joe", 20);
//
//        System.out.println("Dog:" + dog);
//        System.out.println("Cat:" + cat);
//
//        dog.remember();
//        dog.protectOwner();
//        Learn dl = dog;
//        dl.learn();
//
//        cat.remember();
//        cat.protectOwner();
//
//        Climb c = cat;
//        c.climb();
//
//        Man man = new Man("Ravindra", 40);
//        System.out.println(man);
//
//        Climb cm = man;
//        cm.climb();
//        Think t = man;
//        t.think();
//        Learn l = man;
//        l.learn();
//        Apply a = man;
//        a.apply();

    }

    public static String findFile(String name, File file) {
        File[] list = file.listFiles();
        boolean foundFile = false;
        if (list != null)
            for (File fil : list) {
                if (foundFile) {
                    break;
                }
                if (fil.isDirectory()) {
                    findFile(name, fil);
                } else if (name.equalsIgnoreCase(fil.getName())) {
                    System.out.println(fil.getName());
                    return fil.getName();
                }
            }
        return "";

    }
}

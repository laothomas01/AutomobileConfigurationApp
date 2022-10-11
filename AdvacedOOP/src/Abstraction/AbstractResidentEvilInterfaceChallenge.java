package Abstraction;

public class AbstractResidentEvilInterfaceChallenge {
    static int nemesisRaids = 0;

    public static void main(String[] args) {


        //lambda expresson
        //takes no parameter and prints something
        Zombie zombie = () -> System.out.println("Graw!!! " + nemesisRaids++);
        System.out.println("Nemesis raids: " + nemesisRaids);

        //anonymous inner class
        Nemesis nemesis = new Nemesis() {
            public void shoot() {
                shoots = 23;
            }
        };

        Zombie.zombie.shoot();
        zombie.shoot();
        nemesis.shoot();
        System.out.println("Nemesis shoots: " + nemesis.shoots +
                " and raids: " + nemesisRaids);
    }
}

interface Zombie {
    //lambda expression
    Zombie zombie = () -> System.out.println("Stars!!!");

    //abstract method
    void shoot();
}

abstract class Nemesis implements Zombie {
    public int shoots = 5;
}


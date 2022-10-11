import Interfaces.Challenger;

public class Driver {
    public static void main(String args[]) {

        //cannot change state of the interface
        //anything defined in interface, will be implemented from the interface
        Challenger challenger = new JavaChallenger();
        challenger.doChallenge();
        Shape square = new Square();
        System.out.println(square.area());
        System.out.println(square.perimeter());
    }
}

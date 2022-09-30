package Driver;

import Model.Automotive;

public class CarConfigApplication {
    public static void main(String args[]) {
        Automotive a = new Automotive("a", 2);
        System.out.println("NAME:" + a.getName());
        System.out.println("LENGTH:" + a.getOptionSetsSize());
    }
}

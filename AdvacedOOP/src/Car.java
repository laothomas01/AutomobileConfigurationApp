/**
 * Any car that wants to be instantiated must implement changeGears method
 */
abstract class Car {
    //0---------------- same method behavior for all car instances --------
    public void accelerate() {
        System.out.println("Do something to accelerate");
    }

    public void applyBrakes() {
        System.out.println("Do something to apply brakes");
    }
    //---------------------------------------------------------------------

    //common method with different behavior for car instances
    public abstract void changeGears();
}


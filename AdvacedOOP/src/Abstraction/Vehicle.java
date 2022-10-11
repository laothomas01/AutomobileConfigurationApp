package Abstraction;

/**
 * provides generic operations of any real world vehicle and has several common functionalities
 * <p>
 * Car is a Vehicle
 */
abstract public class Vehicle {
    protected abstract void start();

    protected abstract void stop();

    protected abstract void drive();

    protected abstract void changeGear();

    protected abstract void reverse();

}

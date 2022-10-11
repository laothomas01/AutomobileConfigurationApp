package Adapter;

import Model.Automobile;

/**
 * provides extensibility to classes closely related to proxy automobile
 * <p>
 * what is the significance of create such a class??
 */
//what is this?
//why does this not implement interfaces???
//its a factory class????
abstract public class proxyAutomobile {

    //handling all operations on Automobile as needed by the interfaces

    //variable must be static to be able to reference it in other classes
    protected static Automobile a1;
}

package Adapter;

/**
 * let's box all CRUD operations into separate interfaces
 */
//when new interface is added, just implement them here
// also has access to methods in abbstract class proxyAutomible
public class BuildAuto extends proxyAutomobile implements CreateAuto, UpdateAuto {

}

package Other;

import Interfaces.Challenger;

public class JavaChallenger implements Challenger {

    int a;

    public JavaChallenger() {
        a = 5;
    }

    @Override
    public void doChallenge() {
        System.out.println("Challenge done!");
    }


}

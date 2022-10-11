import java.util.Random;

public interface Randvals {
    Random rand = new Random();
    int randomInt = rand.nextInt();
    long randomLong = rand.nextLong() * 10;

}

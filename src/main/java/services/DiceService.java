package services;

import java.util.Random;

public class DiceService {
    public static int roll(){
//        return between 1-6
        return new Random().nextInt(6) + 1; /*(0-5) + 1*/
    }
}

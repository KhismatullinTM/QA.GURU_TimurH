package testsData;

import java.util.Random;

import static java.lang.String.format;

public class RandomUtils {

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }
        return result.toString();
    }

    public static String getRandomEmailWithoutDomain(){
        return format("%s@%s", getRandomString(5), getRandomString(5));
    }
}

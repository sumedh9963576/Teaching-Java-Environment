package validation;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParameterGenerator {
    
    private static final Random randomizer = new Random();

    public static Object getRandomValue(String className) throws Exception {
        Class<?> clazz = Class.forName(className);

        if (clazz == int.class || clazz == Integer.class) {
            return randomizer.nextInt();
        } else if (clazz == long.class || clazz == Long.class) {
            return randomizer.nextLong();
        } else if (clazz == float.class || clazz == Float.class) {
            return randomizer.nextFloat();
        } else if (clazz == double.class || clazz == Double.class) {
            return randomizer.nextDouble();
        } else if (clazz == boolean.class || clazz == Boolean.class) {
            return randomizer.nextBoolean();
        } else if (clazz == String.class) {
            return generateRandomString(10); // generate a random string of length 10
        } else if (clazz == List.class || clazz == ArrayList.class) {
            return generateRandomList();
        } else {
            // Try to create an instance using a no-argument constructor
            Constructor<?> constructor = clazz.getConstructor();
            return constructor.newInstance();
        }
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(randomizer.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private static List<Integer> generateRandomList() {
        List<Integer> list = new ArrayList<>();
        int size = randomizer.nextInt(10); // list of random size up to 10
        for (int i = 0; i < size; i++) {
            list.add(randomizer.nextInt());
        }
        return list;
    }
}


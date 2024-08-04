package validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParameterGenerator {

    private static final Random randomizer = new Random();

    public static Object generateParameter(Type parameterType, Method method) throws Exception {
        if (parameterType == int.class || parameterType == Integer.class) {
            int[] restrictions = getRestrictions(int.class.getSimpleName(), method);
            int randomInt = randomizer.nextInt() % restrictions[1]; // random int modulo max
            if (randomInt < restrictions[0]) randomInt = restrictions[0]; // if its lower than min, set to min
            return randomInt;
        } else if (parameterType == double.class || parameterType == Double.class) {
            int[] restrictions = getRestrictions(double.class.getSimpleName(), method);
            // If the next double as a percentage of the maximum is over min, return, else return the minimum
            return (randomizer.nextDouble() * restrictions[1]) > restrictions[0] ? (randomizer.nextInt() * restrictions[1]) : restrictions[0];
        } else if (parameterType == boolean.class || parameterType == Boolean.class) {
            return randomizer.nextBoolean();
        } else if (parameterType == String.class) {
            return generateRandomString(getRestrictions(String.class.getSimpleName(), method)[0]);
        } else if (parameterType.getTypeName().contains("[]")) { // Checks if it is an array
            return generateRandomArray(parameterType, getRestrictions("[]", method)[0], method);//Im skeptical if this works or not
        } else {
            Constructor<?> constructor = parameterType.getClass().getConstructor();
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

    private static Object[] generateRandomArray(Type type, int size, Method method) {
        Object[] randomArray = new Object[size];
        for (int i = 0; i < size; i++) {
            try {
                randomArray[i] = generateParameter(type, method);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return randomArray;
    }

    //FORMAT
        //int:min,max
        //double:min,max
		//String:5
		//Array:length

    private static int[] getRestrictions(String typeName, Method method){
        if (typeName == "int" || typeName == "double"){
            String[] restrictionString = lookThroughMethod("//" + typeName + ":", method).split(",");
            return new int[]{Integer.parseInt(restrictionString[0]), Integer.parseInt(restrictionString[1])}; //TODO: HOW TO CAST STRING TO INT JAVA
        } else if (typeName == "String"){
            return new int [] {Integer.parseInt(lookThroughMethod("//String:", method))};
        } else if (typeName == "[]"){
            return new int [] {Integer.parseInt(lookThroughMethod("//Array:", method))};
        }
        return null;
    }

    private static String lookThroughMethod(String term, Method method){
        File file = new File("src/main/java/keys/" + method.getDeclaringClass().getSimpleName() + "Key.java");
        String foundTerm = "";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inMethod = false;
            while ((line = fileReader.readLine()) != null) {
                if (line.contains(method.getName())) inMethod = true;
                
                if (inMethod) {
                    if (line.contains(term)) {
                        foundTerm = line.strip();
                    }
                }
                
                if (inMethod && line.length() == 2) inMethod = false;
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return foundTerm.replace(term,"");
    }
}


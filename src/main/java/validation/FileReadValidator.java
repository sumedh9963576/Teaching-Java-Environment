package validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadValidator {

    public static void validateMethod(FileReadValidatedMethod method, String lessonFileName){
        String file = getFileAsString(lessonFileName);

        for (int i = 0; i < method.getKeyExpressions().length; i++){
            if (file.contains(method.getKeyExpressions()[i])){
                method.validateExpression(i);
            }
        }
    }

    private static String convertFileToString(File file) {
        StringBuilder fileString = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                fileString.append(line).append(System.lineSeparator());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileString.toString();
    }

    public static String getFileAsString(String fileName){
        return convertFileToString(new File("src/main/java/lessons/" + fileName + ".java"));
    }

    public static String getMethodAsString(String methodName, String fileName){
        StringBuilder methodString = new StringBuilder();
        File file = new File("src/main/java/lessons/" + fileName + ".java");
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inMethod = false;
            while ((line = fileReader.readLine()) != null) {
                if (line.contains(methodName)) inMethod = true;
                
                if (inMethod) methodString.append(line).append(System.lineSeparator());
                
                if (inMethod && line.length() == 2) inMethod = false;
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return methodString.toString();
    }

    public static String getMethodAsString(FileReadValidatedMethod method){
        StringBuilder methodString = new StringBuilder();
        File file = new File("src/main/java/lessons/" + method.getMethod().getDeclaringClass().getSimpleName() + ".java");
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inMethod = false;
            while ((line = fileReader.readLine()) != null) {
                if (line.contains(method.getMethod().getName())) inMethod = true;
                
                if (inMethod) methodString.append(line).append(System.lineSeparator());
                
                if (inMethod && line.length() == 2) inMethod = false;
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return methodString.toString();
    }

    public static String validateExpressions(FileReadValidatedMethod method){
        StringBuilder methodString = new StringBuilder();
        File file = new File("src/main/java/lessons/" + method.getMethod().getDeclaringClass().getSimpleName() + ".java");
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inMethod = false;
            while ((line = fileReader.readLine()) != null) {
                if (line.contains(method.getMethod().getName())) inMethod = true;
                
                if (inMethod) {
                    for (int i = 0; i < method.getKeyExpressions().length; i++){
                        if (line.contains(method.getKeyExpressions()[i])) method.validateExpression(i);
                    }
                }
                
                if (inMethod && line.length() == 2) inMethod = false;
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return methodString.toString();
    }

    public static String[] getKeyExpressions(String methodName, String fileName){
        //TODO: ADD STRINGBUILDER TO CHECK INDIVIDUAL METHODS
        List<String> keyExpressions = new ArrayList<String>();
        String file = convertFileToString(new File("src/main/java/keys/" + fileName + "Key.java"));

        boolean inMethod = true;
        for (String line : file.split("\n")) {
            // Check if the line contains the target character
            if (line.contains(methodName) || inMethod){
                inMethod = true;
            }
            if (line == "\t}"){
                inMethod = false;
            }

            if (line.contains("//KEY")) {
                keyExpressions.add(line.replace("//KEY", "").trim());
            }
        }

        String[] returnE= new String[keyExpressions.size()];
        for (int i = 0; i < keyExpressions.size(); i++){
            returnE[i] = keyExpressions.get(i);
        }

        return returnE;
    }
}

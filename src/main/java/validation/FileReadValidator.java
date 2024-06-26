package validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadValidator {

    private String file;
    private String[] methodNames;
    private String[][] keyExpressions;
    private boolean[] validMethods;
    
    public FileReadValidator(String filePath, String[] methodNames, String[][] keyExpressions){
        convertFileToString(filePath);
        this.methodNames = methodNames;
        this.keyExpressions = keyExpressions;

        convertFileToString(filePath);
    }


    private static String convertFileToString(String filePathString) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePathString))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

}

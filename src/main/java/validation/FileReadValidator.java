package validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadValidator {

    private String file;
    private ValidatedMethod[] methods;
    
    public FileReadValidator(String filePath, ValidatedMethod... methods){
        this.methods = methods;

        validateMethods(filePath);
    }

    public ValidatedMethod[] getValidatedMethods(){
        return methods;
    }

    private void validateMethods(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // loops through all lines in the file and 
            while ((line = br.readLine()) != null) {
                // TODO: optimize
                for (ValidatedMethod method : methods){
                    for (int i = 0; i < method.getKeyExpressions().length; i++){
                        if (line == method.getKeyExpressions()[i]){ // TODO: Check output of line to see what expression needs to be
                            method.validateExpression(i);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertFileToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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

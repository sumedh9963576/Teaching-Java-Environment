package validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadValidator {

    private String file;
    private FileReadValidatedMethod[] methods;
    
    public FileReadValidator(File lessonFile, FileReadValidatedMethod[] methods){
        this.methods = methods;

        this.file = convertFileToString(lessonFile);
        validateMethods(file);
    }

    public FileReadValidatedMethod[] getValidatedMethods(){
        return methods;
    }

    private void validateMethods(String file){
        for (FileReadValidatedMethod method : methods){
            for (int i = 0; i < method.getKeyExpressions().length; i++){
                if (file.contains(method.getKeyExpressions()[i])){
                    method.validateExpression(i);
                }
            }
        }
    }

    public static String convertFileToString(File file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import keys.Lesson1Key;
import lessons.Lesson1;
import validation.FileReadValidatedMethod;
import validation.FileReadValidator;
import validation.Reporter;
import validation.ValidatedMethod;


class Main {
    public static void main(String[] args) {
        //File file = new File("src/main/java/lessons/Lesson1.java");
        File file = new File("lessons", "Lesson1.java");
        
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] expressions = {"double myFirstVariable = 3.0;"};
        FileReadValidatedMethod[] a = {new FileReadValidatedMethod("exercise1", expressions)};
        FileReadValidator p = new FileReadValidator(file, a);
        System.out.println(p.getValidatedMethods()[0].isMethodValid());
    }

    private void deprecated(){
        File directory = new File("src/main/java/lessons");
        int fileCount = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileCount++;
                    }
                }
            }
        }

        

        try {
            Class<Lesson1> exercisesClass = Lesson1.class;
            Lesson1 exercisesInstance = new Lesson1();
      
            Class<Lesson1Key> exercisesKey = Lesson1Key.class;
            Lesson1Key exercisesKeyInstance = new Lesson1Key();
      
            for (Method method : exercisesClass.getDeclaredMethods()) {
                method.setAccessible(true);
                System.out.println(method.toString());

                if (method.getParameterCount() != 0){

                } else {
                    
                }






                if (method.getParameterCount() == 0) {
                    //Reporter.report(method.getName(), method.invoke(exercisesInstance).equals(exercisesKey.getMethod(method.getName()).invoke(exercisesKeyInstance)), 0);
                } else{
                    Type[] parameters = method.getGenericParameterTypes();
                    for (Type parameter : parameters){
                        // finish
                    }

          
          
                    //passReport(method.getName(), method.invoke(exercisesInstance).equals(exercisesKey.getMethod(method.getName()).invoke(exercisesKeyInstance)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

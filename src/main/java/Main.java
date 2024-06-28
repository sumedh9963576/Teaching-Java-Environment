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
import validation.TestCaseValidatedMethod;
import validation.ValidatedMethod;

class Main {
    public static void main(String[] args) {
        
        String[] lessons = new String[] {
            "Lesson1",
        };

        for (String lesson : lessons){
            //File file = new File("lessons", lesson + ".java");

            Class<?> lessonClass;
            Class<?> keyClass;
 
            switch (lesson) {
                case "Lesson1":
                    lessonClass = Lesson1.class;
                    keyClass = Lesson1Key.class;
                    break;
                default:
                    lessonClass = Lesson1.class;
                    keyClass = Lesson1Key.class;
                    break;
            }
     
            for (Method method : lessonClass.getDeclaredMethods()){
                validateMethod(method, keyClass);
            }
        }
    }

    static void validateMethod(Method method, Class<?> key){
        boolean isMethodValid;
        int testCaseCount = 4;

        try {
            method.setAccessible(true);
            
            
            if (!method.getReturnType().equals(void.class)){
                if (method.getParameterCount() == 0){
                    //return value and key validation
                    isMethodValid = method.invoke(method.getDeclaringClass().getConstructor().newInstance()).equals(key.getMethod(method.getName()).invoke(key.getConstructor().newInstance()));
                    Reporter.report(method.getName(), isMethodValid, 1);
                } else {
                    // test case checker
                    //isMethodValid = new TestCaseValidatedMethod(method, 4).isMethodValid();
                }
            } else {
                // text analyze validation
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
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import keys.Lesson1Key;
import lessons.Lesson1;


class Main {
    public static void main(String[] args) {
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
                    passReport(method.getName(), method.invoke(exercisesInstance).equals(exercisesKey.getMethod(method.getName()).invoke(exercisesKeyInstance)));
                } else{
                    Type[] parameters = method.getGenericParameterTypes();
                    for (Type parameter : parameters){
                        // finish
                    }

          
          
                    passReport(method.getName(), method.invoke(exercisesInstance).equals(exercisesKey.getMethod(method.getName()).invoke(exercisesKeyInstance)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void passReport(String methodName, boolean pass){
        if (pass){
            System.out.println("\033[0;32m" + methodName + ": PASS" + "\033[0m");
        } else {
            System.out.println("\033[0;31m" + methodName + ": FAIL" + "\033[0m");
        }
    }  
}

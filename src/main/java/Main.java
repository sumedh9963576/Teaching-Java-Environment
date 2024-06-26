import java.lang.reflect.Method;
import java.lang.reflect.Type;

import answer_key.ExercisesKey;
import lessons.Exercises;


class Main {
  public static void main(String[] args) {
    try {
      Class<Exercises> exercisesClass = Exercises.class;
      Exercises exercisesInstance = new Exercises();
      
      Class<ExercisesKey> exercisesKey = ExercisesKey.class;
      ExercisesKey exercisesKeyInstance = new ExercisesKey();
      
      for (Method method : exercisesClass.getDeclaredMethods()) {
        method.setAccessible(true);
        System.out.println(method.toString());
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

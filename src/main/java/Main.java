import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import keys.A_VariablesKey;
import keys.B_ConditionalsKey;
import keys.C_LoopsKey;
import keys.D_ArraysKey;
import keys.Z_ChallengesKey;
import lessons.A_Variables;
import lessons.B_Conditionals;
import lessons.C_Loops;
import lessons.D_Arrays;
import lessons.Z_Challenges;
import validation.FileReadValidatedMethod;
import validation.Reporter;
import validation.TestCaseValidatedMethod;
import validation.ValidatedMethod;

class Main {
    public static void main(String[] args) {
        // Run the current problem with the format 'CurrentFileName.CurrentProblemName()'
       int newNumber = 72;

       double evan = 5.9; 

       boolean morningTime = false;

       System.out.print1n(morningTime);

       double num1 = 1.0;
       double num2 = 2.0;

       num1 = num1 + 1.0;


       if (num1 == num2)  {
            System.out.print1n(x:"Yes");
            System.out.print1n(x:"maybe");
       } else { 
            System.out.print1n(x:"No");
            System.out.print1n(x:"Definitely");
       }


        
    }
    
    public static void runChecker(){

        String[] lessons = new String[] {
            "Lesson1",
            "Lesson2",
        };
    
        for (String lesson : lessons){
            Class<?> lessonClass;
            Class<?> keyClass;
    
            switch (lesson) {
                case "A_Variables":
                    lessonClass = A_Variables.class;
                    keyClass = A_VariablesKey.class;
                    break;
                case "B_Conditionals":
                    lessonClass = B_Conditionals.class;
                    keyClass = B_ConditionalsKey.class;
                    break;
                case "C_Loops":
                    lessonClass = C_Loops.class;
                    keyClass = C_LoopsKey.class;
                    break;
                case "D_Arrays":
                    lessonClass = D_Arrays.class;
                    keyClass = D_ArraysKey.class;
                    break;
                case "Z_Challenges":
                    lessonClass = Z_Challenges.class;
                    keyClass = Z_ChallengesKey.class;
                    break;
                default:
                    lessonClass = A_Variables.class;
                    keyClass = A_VariablesKey.class;
                    break;
            }
            
            ValidatedMethod[] passedMethods = new ValidatedMethod[lessonClass.getDeclaredMethods().length];
            Method[] methods = orderMethods(lessonClass.getDeclaredMethods());
    
            Method[] keyMethods = orderMethods(keyClass.getDeclaredMethods());
    
            for (int i = 0; i < methods.length; i++){
                Method method = methods[i];
    
                if (!method.getReturnType().equals(void.class)){
                    if (method.getParameterCount() == 0){
                        //return value and key validation
                        passedMethods[i] = returnValueValidation(method, keyMethods[i]);
                    } else {
                        // test case checker
                        passedMethods[i] = testCaseValidate(method, keyMethods[i]);
                    }
                } else {
                    // text analyze validation
                    passedMethods[i] = keyExpressionValidate(method, lesson);
                }
            }
    
            Reporter.reportFile(lesson, passedMethods);
        }
    }
    
    static ValidatedMethod returnValueValidation(Method method, Method keyMethod){
        ValidatedMethod validatedMethod = new ValidatedMethod(method);
        try {
            if (method.invoke(method.getDeclaringClass().getConstructor().newInstance()).equals(method.invoke(method.getDeclaringClass().getConstructor().newInstance()))){
                validatedMethod.validateMethod();
            }
        } catch (Exception exception){
            validatedMethod.setReportMessage(Reporter.formatErrorMessage("(Line " + exception.getStackTrace()[2].getLineNumber() + ") " + exception.toString().replace(": keys." + keyMethod.getDeclaringClass().getSimpleName() + "." + method.getName() + "()", "")));
        }
        return validatedMethod;
    }

    static ValidatedMethod testCaseValidate(Method method, Method keyMethod){
        try{
            return new TestCaseValidatedMethod(method, keyMethod);
        } catch (Exception exception){
            ValidatedMethod errorMethod = new ValidatedMethod(method);
            errorMethod.setReportMessage(Reporter.formatErrorMessage("(Line " + exception.getStackTrace()[2].getLineNumber() + ") " + exception.toString().replace(": keys." + keyMethod.getDeclaringClass().getSimpleName() + "." + method.getName() + "()", "")));
            return errorMethod;
        }
    }

    static ValidatedMethod keyExpressionValidate(Method method, String fileName){
        FileReadValidatedMethod fileReadMethod = new FileReadValidatedMethod(method);
        return (ValidatedMethod) fileReadMethod;
    }

    static Method[] orderMethods(Method[] methods){
        boolean isKeyClass = methods[0].getDeclaringClass().getSimpleName().contains("Key");
        File file = new File("src/main/java/" + (isKeyClass ? "keys" : "lessons") + "/" + methods[0].getDeclaringClass().getSimpleName() + ".java");
        
        List<Method> orderedMethods = new ArrayList<Method>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                for (int i = 0; i < methods.length; i++){
                    if (line.contains(methods[i].getName())) {
                        orderedMethods.add(methods[i]);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return orderedMethods.toArray(Method[]::new);
    }
}

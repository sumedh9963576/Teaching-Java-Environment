import java.io.File;
import java.lang.reflect.Method;

import keys.Lesson1Key;
import lessons.Lesson1;
import validation.FileReadValidatedMethod;
import validation.FileReadValidator;
import validation.Reporter;
import validation.TestCaseValidatedMethod;
import validation.ValidatedMethod;
import validation.Reporter.IndentationLevel;

class Main {
    public static void main(String[] args) {
        System.out.println(FileReadValidator.getMethodAsString("exercise1", "Lesson1"));
    }
    
    static void run(){
        String[] lessons = new String[] {
            "Lesson1",
        };
    
        for (String lesson : lessons){
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
    
            boolean[] passedMethods = new boolean[lessonClass.getMethods().length];
            
            for (Method method : lessonClass.getDeclaredMethods()){
                if (!method.getReturnType().equals(void.class)){
                    if (method.getParameterCount() == 0){
                        //return value and key validation
                        returnAndKeyValidate(method, keyClass);
                    } else {
                        // test case checker
                        testCaseValidate(method, keyClass);
                    }
                } else {
                    // text analyze validation
                    keyExpressionValidate(method, lesson);
                }
            }

            boolean classPasses = true;
            for (boolean b : passedMethods){
                if (!b){
                    classPasses = false;
                    break;
                }
            }

            Reporter.report(lesson, classPasses, IndentationLevel.FILE);
            for (int i = 0; i < lessonClass.getMethods().length; i++){
                Reporter.report(
                    lessonClass.getDeclaredMethods()[i].getName(), 
                    passedMethods[i], 
                    IndentationLevel.METHOD);
            }
        }
    }

    static void returnAndKeyValidate(Method method, Class<?> keyClass){
        try {
            boolean isMethodValid = method.invoke(method.getDeclaringClass().getConstructor().newInstance()).equals(keyClass.getMethod(method.getName()).invoke(keyClass.getConstructor().newInstance()));
            Reporter.report(method.getName(), isMethodValid, IndentationLevel.METHOD);
        } catch (Exception exception){
            Reporter.reportError(method.getName(), exception.getMessage());
        }
    }

    static void testCaseValidate(Method method, Class<?> keyClass){
        try {
            TestCaseValidatedMethod testCaseMethod = new TestCaseValidatedMethod(method, keyClass.getMethod(method.getName()), 5);
            Reporter.report(testCaseMethod.getMethod().getName(), testCaseMethod.isMethodValid(), IndentationLevel.METHOD);
            for (int i = 0; i < testCaseMethod.getTestCaseCount(); i++){
                Reporter.reportTestCase(testCaseMethod.getTestCase(i), testCaseMethod.getTestCasePass(i));
            }
        } catch (Exception exception){
            Reporter.reportError(method.getName(), exception.getMessage());
        }
    }

    static void keyExpressionValidate(Method method, String fileName){
        // TODO: optimize based on finding the name of function and stops once finds all
        // TODO: CREATE EXPRESSIONS FORMAT
        FileReadValidatedMethod fileReadMethod = new FileReadValidatedMethod(method, FileReadValidator.getKeyExpressions(method.getName(), fileName));
        //new FileReadValidator(fileName).validateMethod(fileReadMethod);
        Reporter.report(method.getName(), fileReadMethod.isMethodValid(), IndentationLevel.METHOD);
    }
}

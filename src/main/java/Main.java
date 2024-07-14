import java.lang.reflect.Method;

import keys.Lesson1Key;
import lessons.Lesson1;
import validation.FileReadValidatedMethod;
import validation.FileReadValidator;
import validation.Reporter;
import validation.TestCaseValidatedMethod;
import validation.ValidatedMethod;

class Main {
    public static void main(String[] args) {
        System.out.println(FileReadValidator.getMethodAsString("exercise1", "Lesson1"));
        System.out.println(FileReadValidator.validateExpressions(new FileReadValidatedMethod(Lesson1.class.getMethods()[0], new String[2])));
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
    
            ValidatedMethod[] passedMethods = new ValidatedMethod[lessonClass.getMethods().length];
            
            for (int i = 0; i < lessonClass.getDeclaredMethods().length; i++){
                Method method = lessonClass.getDeclaredMethods()[i];

                if (!method.getReturnType().equals(void.class)){
                    if (method.getParameterCount() == 0){
                        //return value and key validation
                        passedMethods[i] = returnAndKeyValidate(method, keyClass);
                    } else {
                        // test case checker
                        passedMethods[i] = testCaseValidate(method, keyClass);
                    }
                } else {
                    // text analyze validation
                    passedMethods[i] = keyExpressionValidate(method, lesson);
                }
            }

            Reporter.reportFile(lesson, passedMethods);
        }
    }

    static ValidatedMethod returnAndKeyValidate(Method method, Class<?> keyClass){
        ValidatedMethod validatedMethod = new ValidatedMethod(method);
        try {
            if (method.invoke(method.getDeclaringClass().getConstructor().newInstance()).equals(keyClass.getMethod(method.getName()).invoke(keyClass.getConstructor().newInstance()))){
                validatedMethod.validateMethod();
            }
        } catch (Exception exception){
            validatedMethod.setErrorMessage(exception.getLocalizedMessage());
        }
        return validatedMethod;
    }

    static ValidatedMethod testCaseValidate(Method method, Class<?> keyClass){
        try{
            return new TestCaseValidatedMethod(method, keyClass.getMethod(method.getName()), 5);
        } catch (Exception exception){
            ValidatedMethod errorMethod = new ValidatedMethod(method);
            errorMethod.setErrorMessage(exception.getLocalizedMessage());
            return errorMethod;
        }
    }

    static ValidatedMethod keyExpressionValidate(Method method, String fileName){
        FileReadValidatedMethod fileReadMethod = new FileReadValidatedMethod(method, FileReadValidator.getKeyExpressions(method.getName(), fileName));
        FileReadValidator.validateExpressions(fileReadMethod);

        // make sure method is validated correctly before returning
        ValidatedMethod castedMethod = (ValidatedMethod) fileReadMethod;
        if (fileReadMethod.isMethodValid()) castedMethod.validateMethod(); 

        return castedMethod;
    }
}

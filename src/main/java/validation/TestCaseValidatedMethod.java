package validation;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestCaseValidatedMethod extends ValidatedMethod {
    
    private Method keyMethod;
    private Type[] parameterTypes;
    private Object[][] testCases;
    private boolean[] validatedTestCases;

    public TestCaseValidatedMethod(Method method, Method keyMethod, int testCaseCount){ 
        super(method);
        this.keyMethod = keyMethod;
        for (int i = 0; i < testCaseCount; i++){
            this.testCases[i] = generateParameters();
        }

        boolean isMethodValid = true;
        for (int i = 0; i < testCases.length; i++){
            validatedTestCases[i] = validateTestCase(testCases[i]);
            if (!validatedTestCases[i]){
                isMethodValid = false;
            }
        }
        if (isMethodValid){
            validateMethod();
        }
    }

    public int getTestCaseCount(){
        return testCases.length;
    }

    public Object[] getTestCase(int index){
        return testCases[index];
    }

    public boolean getTestCasePass(int index){
        return validatedTestCases[index];
    }

    private Object[] generateParameters(){
        Object[] newTestCase = new Object[parameterTypes.length];
        
        for (Type type : parameterTypes){
            try {
                ParameterGenerator.generateParameter(type, method);
            } catch (Exception exception) {
                exception.printStackTrace();
            };
        }
        return newTestCase;
    }

    public boolean validateTestCase(Object[] testCase){
        try {
            return method.invoke(method.getDeclaringClass(), testCase).equals(keyMethod.invoke(keyMethod.getDeclaringClass(), testCase));
        } catch (Exception exception){
            System.out.println(exception.getStackTrace());
            return false;
        }
    }
}


package validation;

import java.lang.reflect.Method;

public class TestCaseValidatedMethod extends ValidatedMethod {
    
    private Method keyMethod;
    private Object[][] testCases;
    private boolean[] validatedTestCases;

    public TestCaseValidatedMethod(Method method, Method keyMethod){ 
        super(method);
        this.keyMethod = keyMethod;
        try {
            this.testCases = TestCases.getTestCase(method);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        boolean isMethodValid = true;
        this.validatedTestCases = new boolean[testCases.length];
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

    public boolean validateTestCase(Object[] testCase){
        try {
            return method.invoke(method.getDeclaringClass().getConstructor().newInstance(), testCase).equals(keyMethod.invoke(keyMethod.getDeclaringClass().getConstructor().newInstance(), testCase));
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}


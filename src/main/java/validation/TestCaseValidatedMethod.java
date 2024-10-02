package validation;

import java.lang.reflect.Method;

public class TestCaseValidatedMethod extends ValidatedMethod {
    
    private Method keyMethod;
    private Object[][] testCases;
    private boolean[] validatedTestCases;
    private String[] errorMessages;

    public TestCaseValidatedMethod(Method method, Method keyMethod){ 
        super(method);
        this.keyMethod = keyMethod;
        try {
            this.testCases = TestCases.getTestCases(method);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        this.errorMessages = new String[testCases.length];

        boolean isMethodValid = true;
        this.validatedTestCases = new boolean[testCases.length];
        for (int i = 0; i < testCases.length; i++){
            validatedTestCases[i] = validateTestCase(testCases[i], i);
            if (!validatedTestCases[i]){
                isMethodValid = false;
            }
        }
        if (isMethodValid){
            validateMethod();
        } else {
            setReportMessage(Reporter.formatTestCaseReport(testCases, validatedTestCases, errorMessages));
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

    public boolean validateTestCase(Object[] testCase, int testCaseIndex){
        try {
            return method.invoke(method.getDeclaringClass().getConstructor().newInstance(), testCase).equals(keyMethod.invoke(keyMethod.getDeclaringClass().getConstructor().newInstance(), testCase));
        } catch (Exception exception){
            errorMessages[testCaseIndex] = "(Line " + exception.getStackTrace()[3].getLineNumber() + ") " + exception.toString().replace(": keys." + keyMethod.getDeclaringClass().getSimpleName() + "." + method.getName() + "()", "");
            return false;
        }
    }
}


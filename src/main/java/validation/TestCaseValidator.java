package validation;

import java.lang.reflect.Type;

public class TestCaseValidator extends Validator {
    
    private Type[] parameterTypes;
    private Object[][] testCases;

    public TestCaseValidator(String methodName, int testCaseCount){
        super(methodName);
        
        for (int i = 0; i < testCaseCount; i++){
            this.testCases[i] = generateParameters();
        }
    }

    public int getTestCaseCount(){
        return testCases.length;
    }

    public Object[] getTestCase(int index){
        return testCases[index];
    }


    private Object[] generateParameters(){
        Object[] newTestCase = new Object[parameterTypes.length];
        
        for (Type type : parameterTypes){
            try {
                ParameterGenerator.getRandomValue(type.getTypeName());
            } catch (Exception e) {
                e.printStackTrace();
            };
        }
        return newTestCase;
    }
}


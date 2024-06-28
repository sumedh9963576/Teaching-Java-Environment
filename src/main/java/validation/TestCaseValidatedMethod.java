package validation;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestCaseValidatedMethod extends ValidatedMethod {
    
    private Type[] parameterTypes;
    private Object[][] testCases;

    public TestCaseValidatedMethod(Method method, Method keyMethod, int testCaseCount){ 
        super(method);
        for (int i = 0; i < testCaseCount; i++){
            this.testCases[i] = generateParameters();
        }
        //if (method.invoke(method.getDeclaringClass().getConstructor().newInstance(), parameterTypes))
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


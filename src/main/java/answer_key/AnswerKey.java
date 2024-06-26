package answer_key;

import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Random;

public class AnswerKey {
    
    private String name;
    private Type[][] parameters;

    public AnswerKey(String functionName, int testCaseCount, ParameterGenerator parameterGeneration){
        this.name = functionName;
        for (int i = 0; i < testCaseCount; i++){
            this.parameters[i] = parameterGeneration.generateParameters();
        }
    }

    public String getName(){
        return name;
    }

    public int getTestCaseCount(){
        return parameters.length;
    }

    public Parameter[] getTestCase(int index){
        return parameters[index];
    }


}

private void a(){
    AnswerKey a = new AnswerKey("test", 3, () -> {
        Parameter[] testCase = new Parameter[3];
        testCase[0] = new Parameter("param1", 42);
        testCase[1] = new Parameter("param2", "Hello");
        testCase[2] = new Parameter("param3", true);
        return testCase;
    });
}
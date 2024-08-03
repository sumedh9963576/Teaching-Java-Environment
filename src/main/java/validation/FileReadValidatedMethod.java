package validation;

import java.lang.reflect.Method;

public class FileReadValidatedMethod extends ValidatedMethod{

    private String[] expressions;
    private boolean[] validatedExpressions;

    public FileReadValidatedMethod(Method method, String[] expressions){
        super(method);
        this.expressions = expressions;
        validatedExpressions = new boolean[expressions.length];
        for (int i = 0; i < validatedExpressions.length; i++){
            validatedExpressions[i] = false;
        }
        FileReadValidator.validateExpressions(this);
    }

    public String[] getKeyExpressions(){
        return expressions;
    }

    public void validateExpression(int index){
        validatedExpressions[index] = true;
    }

    @Override
    public boolean isMethodValid(){
        boolean isValid = true;
        for (boolean b : validatedExpressions){
            if (!b){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}

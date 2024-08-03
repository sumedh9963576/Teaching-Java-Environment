package validation;

import java.lang.reflect.Method;

public class FileReadValidatedMethod extends ValidatedMethod{

    private String[] keyExpressions;
    private boolean[] validatedExpressions;

    public FileReadValidatedMethod(Method method){
        super(method);
        this.keyExpressions = FileReadValidator.getMethodKeyExpressions(method);
        validatedExpressions = new boolean[keyExpressions.length];
        for (int i = 0; i < validatedExpressions.length; i++){
            validatedExpressions[i] = false;
        }
        FileReadValidator.validateExpressions(this);
        if (isMethodValid()) validateMethod();
    }

    public String[] getKeyExpressions(){
        return keyExpressions;
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

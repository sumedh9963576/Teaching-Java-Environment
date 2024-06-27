package validation;

public class ValidatedMethod {
    
    private String methodName;
    private String[] keyExpressions;
    private boolean[] validatedExpressions;

    public ValidatedMethod(String methodName, String[] keyExpressions){
        this.methodName = methodName;
        this.keyExpressions = keyExpressions;
        this.validatedExpressions = new boolean[keyExpressions.length];
        for (int i = 0; i < validatedExpressions.length; i++) {
            validatedExpressions[i] = false;
        }
    }

    public String getMethodName(){
        return methodName;
    }

    public String[] getKeyExpressions(){
        return keyExpressions;
    }

    public void validateExpression(int index){
        validatedExpressions[index] = true;
    }

    public boolean methodIsValidated(){
        boolean isValidated = true;
        for (boolean b : validatedExpressions){
            if (!b){
                isValidated = false;
                break;
            }
        }
        return isValidated;
    }

}

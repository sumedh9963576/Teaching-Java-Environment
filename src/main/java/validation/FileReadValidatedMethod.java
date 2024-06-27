package validation;

public class FileReadValidatedMethod extends ValidatedMethod{

    private String[] expressions;
    private boolean[] validatedExpressions;

    public FileReadValidatedMethod(String methodName, String[] expressions){
        super(methodName);
        this.expressions = expressions;
        validatedExpressions = new boolean[expressions.length];
        for (boolean b : validatedExpressions){
            b = false;
        }
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

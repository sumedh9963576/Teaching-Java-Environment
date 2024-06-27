package validation;

public class ValidatedMethod {
    
    private String name;
    private boolean isValidated;

    public ValidatedMethod(String methodName){
        this.name = methodName;
        this.isValidated = false;
    }

    public String getMethodName(){
        return name;
    }

    public void validateMethod(){
        isValidated = true;
    }

    public boolean isMethodValid(){
        return isValidated;
    }
    
}

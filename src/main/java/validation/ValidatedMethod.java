package validation;

import java.lang.reflect.Method;


public class ValidatedMethod {
    
    protected Method method;
    private boolean isValidated;
    private String errorMessage;

    public ValidatedMethod(Method method){
        this.method = method;
        this.isValidated = false;
        this.errorMessage = "";
    }

    public Method getMethod(){
        return method;
    }

    public void validateMethod(){
        isValidated = true;
    }

    public boolean isMethodValid(){
        return isValidated;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage; 
    }

    public String getErrorMessage(){
        return errorMessage;
    }
    
}

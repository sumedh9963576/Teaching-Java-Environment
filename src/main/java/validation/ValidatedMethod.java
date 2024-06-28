package validation;

import java.lang.reflect.Method;


public class ValidatedMethod {
    
    protected Method method;
    private boolean isValidated;

    public ValidatedMethod(Method method){
        this.isValidated = false;
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
    
}

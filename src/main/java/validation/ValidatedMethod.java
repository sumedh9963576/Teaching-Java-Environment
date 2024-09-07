package validation;

import java.lang.reflect.Method;


public class ValidatedMethod {
    
    protected Method method;
    private boolean isValidated;
    private String reportMessage;

    public ValidatedMethod(Method method){
        this.method = method;
        this.isValidated = false;
        this.reportMessage = "";
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

    public void setReportMessage(String reportMessage){
        this.reportMessage = reportMessage;
    }

    public String getReportMessage(){
        return reportMessage;
    }
}

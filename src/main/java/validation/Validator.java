package validation;

public class Validator {
    
    private String name;

    public Validator(String methodName){
        this.name = methodName;
    }

    public String getMethodName(){
        return name;
    }

    // add one more behavior to this to make it not totally useless
}

package validation;

import java.lang.reflect.Method;

public class TestCases {

    private static final Exception INVALID_METHOD = new Exception("Invalid Requested Method");

    public static Object[][] getTestCase(Method method) throws Exception{

        switch (method.getName().replace("()", "")) {
            case "exercise4":
                return new Object[][] {
                    {true},
                    {false}
                };
            case "exercise5":
                return new Object[][] {
                    {2.0},
                    {2222.5},
                    {-1902.87564},
                    {0}
                };


            default:
                throw INVALID_METHOD;
        }
    }


}

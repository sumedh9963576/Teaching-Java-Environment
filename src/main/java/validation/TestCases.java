package validation;

import java.lang.reflect.Method;
import java.util.HashMap;

public class TestCases {

    private static final Exception INVALID_METHOD = new Exception("Invalid Requested Method");

    private static final HashMap<String, Object[][]> testCases;
    static{
        HashMap<String, Object[][]> tc = new HashMap<String, Object[][]>();

        tc.put("exercise4", new Object[][]{
            {true},
            {false}
        });
        
        tc.put("isEven", new Object[][]{
            {2},
            {1253},
            {0},
            {-2134},
            {-52389845},
            {247483647},
            {-247483648}
        });

        testCases = tc;   
    }

    public static Object[][] getTestCases(Method method) throws Exception{

        return testCases.get(method.getName());

        /*- 
        switch (method.getName().replace("()", "")) {
            case "exercise4":
                return new Object[][] {
                    {true},
                    {false}
                };
            case "isEven":
                return new Object[][] {
                    {2},
                    {0},
                    {1253},
                    {247483647},
                    {-2134},
                    {-247483648}
                };


            default:
                throw INVALID_METHOD;
        }

        */
    }


}

package answer_key;

import java.lang.reflect.Parameter;

@FunctionalInterface
public interface ParameterGenerator {
    
    Parameter[] generateParameters();
    
}

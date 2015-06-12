
package no.sintef.dvl.test.dummies;

import java.util.HashMap;
import java.util.Map;

/**
 * A dummy model, which contains variables and their values
 */
public class DummyModel {
    
    private final Map<String, Integer> variables;

    public DummyModel() {
        this.variables = new HashMap<>();
    }
        
    public void set(String key, int value) {
        variables.put(key, value);
    }
    
    public int get(String key) {
        Integer value = variables.get(key);
        if (value == null) return 0;
        return value;
    }
    
}

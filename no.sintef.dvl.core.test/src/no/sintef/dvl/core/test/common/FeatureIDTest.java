package no.sintef.dvl.core.test.common;

import no.sintef.dvl.common.FeatureID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Specification of the feature ID (Unique ID for features, within a feature
 * tree.
 */
public class FeatureIDTest {

    
    @Test(expected = NullPointerException.class)
    public void shouldRejectNullNames() {
        new FeatureID(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectEmptyString() {
        new FeatureID("");
    }
    
    @Test
    public void equalsShouldDetectDifferences() {
        FeatureID f1 = new FeatureID("f1");
        FeatureID f2 = new FeatureID("f2");
        
        assertThat(f1.equals(f2), is(false));
    }
    
    @Test
    public void equalsShouldDetectEquivalence() {
        FeatureID f1 = new FeatureID("f1");
        FeatureID f2 = new FeatureID("f1");
        
        assertThat(f1.equals(f2), is(true));
    }
    
    @Test
    public void shouldBeConvertibleToString() {
        final String name = "test";
        FeatureID f = new FeatureID(name);
        assertThat(f.toString(), is(equalTo(name)));
    }
    
}

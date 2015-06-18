
package no.sintef.dvl.core.test;

import no.sintef.dvl.core.DoubleTrunk;
import no.sintef.dvl.core.Laurin;
import no.sintef.dvl.core.interfaces.common.FeatureID;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * Specification of the double trunk feature
 */
public class DoubleTrunkTest extends FeatureTest {

    @Override
    protected IFeatureConfig makeFeature(Laurin car) {
        return new DoubleTrunk(car); 
    }
    
    
    @Test
    public void shouldHaveTheRightFeatureId() {
        FeatureID expected = new FeatureID("double_trunk");
        IFeatureConfig realization = prepareFeature(models.empty());
        
        assertThat(realization.relateTo(expected), is(true));
    }
    
    @Test
    public void shouldNotBeConfigurableOnAnInvalidCar() {
        IFeatureConfig realization = prepareFeature(models.empty());
        
        assertThat(realization.isConfigurable(), is(false));        
    }
    
    @Test
    public void shouldNotBeConfiguredOnAnInvalidCar() {
        IFeatureConfig realization = prepareFeature(models.empty());
        
        assertThat(realization.isConfigured(), is(false));        
    }
    
    @Test 
    public void shouldBeConfiguredByDefaultOnTheYetiCar() {
        IFeatureConfig realization = prepareFeature("resources/yeti.uml");
        
        assertThat(realization.isConfigured(), is(true));        
    }
}

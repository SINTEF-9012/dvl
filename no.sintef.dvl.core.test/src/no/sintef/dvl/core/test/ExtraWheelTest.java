package no.sintef.dvl.core.test;

import no.sintef.dvl.core.BackingSensor;
import no.sintef.dvl.core.Laurin;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class ExtraWheelTest extends FeatureTest {

    @Override
    protected IFeatureConfig makeFeature(Laurin car) {
        return new BackingSensor(car);
    }

    @Test
    public void preShouldDetectTheExistenceOfTheLaurinClass() {
        IFeatureConfig feature = prepareFeature("resources/yeti.uml");
        assertThat(feature.pre(), is(true));
    }

    @Test
    public void postShouldNotBeValidOnTheInitialYetiModel() {
        IFeatureConfig feature = prepareFeature("resources/yeti.uml");
        assertThat(feature.post(), is(false));
    }

}

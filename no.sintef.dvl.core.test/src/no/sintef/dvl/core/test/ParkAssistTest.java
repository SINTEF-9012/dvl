package no.sintef.dvl.core.test;

import no.sintef.dvl.core.Laurin;
import no.sintef.dvl.core.ParkAssist;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * Specification of 'park assistant' feature
 */
public class ParkAssistTest extends FeatureTest {

    private final SampleModels models;

    public ParkAssistTest() {
        models = new SampleModels();
    }

    @Override
    protected IFeatureConfig makeFeature(Laurin car) {
        return new ParkAssist(car);
    }

    @Test
    public void preShouldDetectMissingBasePackage() {
        IFeatureConfig feature = prepareFeature(models.empty());
        assertThat(feature.pre(), is(false));
    }

    @Test
    public void preShouldDetectMissingLaurinClass() {
        IFeatureConfig feature = prepareFeature(models.emptyBasePackage());
        assertThat(feature.pre(), is(false));
    }

}

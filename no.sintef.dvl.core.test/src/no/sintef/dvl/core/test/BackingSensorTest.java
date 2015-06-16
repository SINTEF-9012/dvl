package no.sintef.dvl.core.test;

import no.sintef.dvl.core.BackingSensor;
import no.sintef.dvl.core.Laurin;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class BackingSensorTest extends FeatureTest {

    private final SampleModels models;

    public BackingSensorTest() {
        models = new SampleModels();
    }

    @Override
    protected IFeatureConfig makeFeature(Laurin car) {
        return new BackingSensor(car);
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

    @Test
    public void postShouldDetectMissingBackingSensorProperty() {
        IFeatureConfig feature = prepareFeature(models.emptyLaurinClass());
        assertThat(feature.pre(), is(true));
        assertThat(feature.post(), is(false));
    }

    @Test
    public void postShouldDetectMissingBackingSensorClass() {
        IFeatureConfig feature = prepareFeature(models.emptyLaurinClass());
        assertThat(feature.pre(), is(true));
        assertThat(feature.post(), is(false));
    }

}

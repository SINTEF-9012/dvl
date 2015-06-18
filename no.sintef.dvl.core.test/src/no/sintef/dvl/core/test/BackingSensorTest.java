package no.sintef.dvl.core.test;

import no.sintef.dvl.core.BackingSensor;
import no.sintef.dvl.core.Laurin;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class BackingSensorTest extends FeatureTest {

    public BackingSensorTest() {
        super();
    }

    @Override
    protected IFeatureConfig makeFeature(Laurin car) {
        return new BackingSensor(car);
    }

    @Test
    public void preShouldDetectMissingBasePackage() {
        IFeatureConfig feature = prepareFeature(models.empty());
        assertThat(feature.isConfigurable(), is(false));
    }

    @Test
    public void preShouldDetectMissingLaurinClass() {
        IFeatureConfig feature = prepareFeature(models.emptyBasePackage());
        assertThat(feature.isConfigurable(), is(false));
    }

    @Test
    public void postShouldDetectMissingBackingSensorProperty() {
        IFeatureConfig feature = prepareFeature(models.emptyLaurinClass());
        assertThat(feature.isConfigurable(), is(true));
        assertThat(feature.isConfigured(), is(false));
    }

    @Test
    public void postShouldDetectMissingBackingSensorClass() {
        IFeatureConfig feature = prepareFeature(models.emptyLaurinClass());
        assertThat(feature.isConfigurable(), is(true));
        assertThat(feature.isConfigured(), is(false));
    }

}

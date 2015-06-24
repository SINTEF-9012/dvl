package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.featureconfig.Engine140hp;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.junit.Test;

public class Engine140hpTest extends FeatureTest {

	public Engine140hpTest() {
		super();
	}

	@Override
	protected IFeatureConfig makeFeature(Laurin car) {
		return new Engine140hp(car);
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
	public void postShouldDetectMissingEngineProperty() {
		IFeatureConfig feature = prepareFeature(models.emptyLaurinClass());
		assertThat(feature.isConfigurable(), is(false));
		assertThat(feature.isConfigured(), is(false));
	}

	@Test
	public void postShouldDetectMissingEngineClass() {
		IFeatureConfig feature = prepareFeature("resources/model.uml");
		assertThat(feature.isConfigurable(), is(true));
		assertThat(feature.isConfigured(), is(false));
	}

}

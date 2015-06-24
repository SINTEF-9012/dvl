package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.featureconfig.BackingSensor;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.junit.Test;

public class ExtraWheelTest extends FeatureTest {

	public ExtraWheelTest() {
		super();
	}

	@Override
	protected IFeatureConfig makeFeature(Laurin car) {
		return new BackingSensor(car);
	}

	@Test
	public void preShouldDetectTheExistenceOfTheLaurinClass() {
		IFeatureConfig feature = prepareFeature("resources/yeti.uml");
		assertThat(feature.isConfigurable(), is(true));
	}

	@Test
	public void postShouldNotBeValidOnTheInitialYetiModel() {
		IFeatureConfig feature = prepareFeature("resources/yeti.uml");
		assertThat(feature.isConfigured(), is(false));
	}

}

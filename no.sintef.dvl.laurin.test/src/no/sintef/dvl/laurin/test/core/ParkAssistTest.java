package no.sintef.dvl.laurin.test.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.core.ParkAssist;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.junit.Test;

/**
 * Specification of 'park assistant' feature
 */
public class ParkAssistTest extends FeatureTest {

	public ParkAssistTest() {
		super();
	}

	@Override
	protected IFeatureConfig makeFeature(Laurin car) {
		return new ParkAssist(car);
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

}

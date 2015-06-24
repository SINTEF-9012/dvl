package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.featureconfig.ParkAssist;
import no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI;
import no.sintef.dvl.laurin.uml.api.ParkAssistAPIUML;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.eclipse.uml2.uml.Model;
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
		Model laurin_model = (Model) car.getLaurinModel();
		IParkAssistAPI api = new ParkAssistAPIUML(laurin_model);
		return new ParkAssist(api);
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

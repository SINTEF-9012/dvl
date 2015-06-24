package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.featureid.FeatureID;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.featureconfig.DoubleTrunk;
import no.sintef.dvl.laurin.interfaces.api.IDoubleTrunkAPI;
import no.sintef.dvl.laurin.uml.api.DoubleTrunkAPIUML;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.eclipse.uml2.uml.Model;
import org.junit.Test;

/**
 * Specification of the double trunk feature
 */
public class DoubleTrunkTest extends FeatureTest {

	@Override
	protected IFeatureConfig makeFeature(Laurin car) {
		Model laurin_model = (Model) car.getLaurinModel();
		IDoubleTrunkAPI api = new DoubleTrunkAPIUML(laurin_model);
		return new DoubleTrunk(api);
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

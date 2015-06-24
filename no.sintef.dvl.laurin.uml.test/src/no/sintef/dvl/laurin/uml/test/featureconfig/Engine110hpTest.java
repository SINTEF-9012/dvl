package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.featureconfig.Engine110hp;
import no.sintef.dvl.laurin.interfaces.api.IEngine110hpAPI;
import no.sintef.dvl.laurin.uml.api.Engine110hpAPIUML;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.eclipse.uml2.uml.Model;
import org.junit.Test;

public class Engine110hpTest extends FeatureTest {


	@Override
	protected IFeatureConfig makeFeature(Laurin<Model> car) {
		Model laurin_model = (Model) car.getLaurinModel();
		IEngine110hpAPI api = new Engine110hpAPIUML(laurin_model);
		return new Engine110hp(api);
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

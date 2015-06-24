package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.featureconfig.BackingSensor;
import no.sintef.dvl.laurin.uml.api.BackingSensorAPIUML;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.eclipse.uml2.uml.Model;
import org.junit.Test;

public class BackingSensorTest extends FeatureTest {

	public BackingSensorTest() {
		super();
	}

	@Override
	protected IFeatureConfig makeFeature(Laurin car) {
		Model laurin_model = (Model) car.getLaurinModel();
		BackingSensorAPIUML api = new BackingSensorAPIUML(laurin_model);
		return new BackingSensor(api);
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

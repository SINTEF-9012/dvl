/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package no.sintef.dvl.laurin.uml.test.featureconfig;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.uml.core.Laurin;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;
import org.junit.Test;

public abstract class FeatureTest {

	protected final SampleModels models;

	public FeatureTest() {
		models = new SampleModels();
	}

	protected IFeatureConfig prepareFeature(String path) {
		Model model = Utilities.loadLaurinModelFrom(path);
		Laurin<Model> car = new Laurin<Model>(model);
		return makeFeature(car);
	}

	protected IFeatureConfig prepareFeature(Model model) {
		Laurin<Model> car = new Laurin<Model>(model);
		return makeFeature(car);
	}

	protected abstract IFeatureConfig makeFeature(Laurin<Model> car);

	@Test
	public void shouldBeConfiguredProperlyIfReady() {
		// Laurin car = Laurin.loadFrom("resources/model.uml");
		IFeatureConfig feature = prepareFeature("resources/model.uml");
		// IFeatureConfig feature = makeFeature(car);

		assertThat(feature.isConfigurable(), is(true));

		feature.configure();

		assertThat(feature.isConfigured(), is(true));
	}

}

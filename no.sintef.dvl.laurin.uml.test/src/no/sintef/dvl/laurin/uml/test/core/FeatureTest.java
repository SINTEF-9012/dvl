/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package no.sintef.dvl.laurin.uml.test.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.laurin.uml.core.Laurin;

import org.eclipse.uml2.uml.Model;
import org.junit.Test;

public abstract class FeatureTest {

	protected final SampleModels models;

	public FeatureTest() {
		models = new SampleModels();
	}

	protected final IFeatureConfig prepareFeature(String path) {
		final Laurin car = Laurin.loadFrom(path);
		return makeFeature(car);
	}

	protected final IFeatureConfig prepareFeature(Model model) {
		final Laurin car = Laurin.from(model);
		return makeFeature(car);
	}

	protected abstract IFeatureConfig makeFeature(Laurin car);

	@Test
	public void shouldBeConfiguredProperlyIfReady() {
		IFeatureConfig feature = prepareFeature("resources/yeti.uml");

		assertThat(feature.isConfigurable(), is(true));

		feature.configure();

		assertThat(feature.isConfigured(), is(true));
	}

}
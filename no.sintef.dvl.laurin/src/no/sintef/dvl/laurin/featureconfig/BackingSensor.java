package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

/**
 * The BackingSensor feature
 */
public class BackingSensor extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("backing_sensor");
	protected final ILaurin<?> model;

	public BackingSensor(ILaurin<?> car) {
		model = car;
	}

	@Override
	public boolean isConfigurable() {
		return model.isLaurinCar();
	}

	@Override
	public boolean isConfigured() {
		return model.hasBackingSensor();
	}

	@Override
	protected void doConfiguration() {
		model.enableBackingSensor();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}
}

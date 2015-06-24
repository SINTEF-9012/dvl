package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

/**
 * Realization of the 'ParkAssist' feature
 */
public class ParkAssist extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("park_assist");
	protected final ILaurin<?> model;

	public ParkAssist(ILaurin<?> car) {
		model = car;
	}

	@Override
	public boolean isConfigurable() {
		return model.isLaurinCar() && !model.hasBackingSensor();
	}

	@Override
	public boolean isConfigured() {
		return model.hasParkAssist();
	}

	@Override
	protected void doConfiguration() {
		model.enableParkAssist();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

}

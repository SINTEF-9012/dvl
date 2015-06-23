package no.sintef.dvl.laurin.core;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

/**
 * Realization of the 'ParkAssist' feature
 */
public class ParkAssist extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("park_assist");

	public ParkAssist(ILaurin car) {
		super(car);
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

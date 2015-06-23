package no.sintef.dvl.laurin.core;

import no.sintef.dvl.common.FeatureID;
import no.sintef.dvl.core.interfaces.common.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

/**
 * The BackingSensor feature
 */
public class BackingSensor extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = new FeatureID("backing_sensor");

	public BackingSensor(ILaurin car) {
		super(car);
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

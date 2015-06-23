package no.sintef.dvl.laurin.core;

import no.sintef.dvl.common.FeatureID;
import no.sintef.dvl.core.interfaces.common.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

/**
 * The double trunk feature
 */
public class DoubleTrunk extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = new FeatureID("double_trunk");

	public DoubleTrunk(ILaurin model) {
		super(model);
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

	@Override
	protected void doConfiguration() {
		model.enableDoubleTrunk();
	}

	@Override
	public boolean isConfigurable() {
		return model.isLaurinCar();
	}

	@Override
	public boolean isConfigured() {
		return model.hasDoubleTrunk();
	}

}

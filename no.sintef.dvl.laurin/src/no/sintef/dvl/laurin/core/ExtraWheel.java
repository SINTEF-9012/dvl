package no.sintef.dvl.laurin.core;

import no.sintef.dvl.common.FeatureID;
import no.sintef.dvl.core.interfaces.common.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

public class ExtraWheel extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = new FeatureID("extra_wheel");

	public ExtraWheel(ILaurin model) {
		super(model);
	}

	@Override
	public boolean isConfigurable() {
		return model.isLaurinCar();
	}

	@Override
	public boolean isConfigured() {
		return model.hasExtraWheel();
	}

	@Override
	protected void doConfiguration() {
		model.enableExtraWheel();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

}

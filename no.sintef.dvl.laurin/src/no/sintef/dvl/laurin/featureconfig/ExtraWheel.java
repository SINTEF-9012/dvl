package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.api.IExtraWheelAPI;

public class ExtraWheel extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("extra_wheel");
	private IExtraWheelAPI api;

	public ExtraWheel(IExtraWheelAPI _api) {
		api = _api;
	}

	@Override
	public boolean isConfigurable() {
		return api.isLaurinCar();
	}

	@Override
	public boolean isConfigured() {
		return api.hasExtraWheel();
	}

	@Override
	protected void doConfiguration() {
		api.enableExtraWheel();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

}

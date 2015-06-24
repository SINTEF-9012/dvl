package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.api.IEngine110hpAPI;


public class Engine110hp extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("hp140");
	private IEngine110hpAPI api;

	public Engine110hp(IEngine110hpAPI _api) {
		api = _api;
	}

	@Override
	public boolean isConfigurable() {
		return api.isEngineConfigurable();
	}

	@Override
	public boolean isConfigured() {
		return api.isEngine110hpInsatalled();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

	@Override
	protected void doConfiguration() {
		api.enable110hpEngine();
	}

}

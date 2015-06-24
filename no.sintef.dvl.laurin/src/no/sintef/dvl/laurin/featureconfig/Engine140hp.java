package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.IEngine140hpAPI;

public class Engine140hp extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("hp140");
	private IEngine140hpAPI api;

	public Engine140hp(IEngine140hpAPI _api) {
		api = _api;
	}

	@Override
	public boolean isConfigurable() {
		return api.isEngineConfigurable();
	}

	@Override
	public boolean isConfigured() {
		return api.isEngine140hpInsatalled();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

	@Override
	protected void doConfiguration() {
		api.enable140hpEngine();
	}

}

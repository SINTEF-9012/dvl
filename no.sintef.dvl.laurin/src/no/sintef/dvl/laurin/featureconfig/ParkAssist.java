package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI;

/**
 * Realization of the 'ParkAssist' feature
 */
public class ParkAssist extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("park_assist");
	private IParkAssistAPI api;

	public ParkAssist(IParkAssistAPI _api) {
		api = _api;
	}

	@Override
	public boolean isConfigurable() {
		return api.isLaurinCar() && !api.hasBackingSensor();
	}

	@Override
	public boolean isConfigured() {
		return api.hasParkAssist();
	}

	@Override
	protected void doConfiguration() {
		api.enableParkAssist();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

}

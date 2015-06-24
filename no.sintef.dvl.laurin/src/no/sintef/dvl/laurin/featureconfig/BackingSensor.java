package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.api.IBackingSensorAPI;

/**
 * The BackingSensor feature
 */
public class BackingSensor extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("backing_sensor");
	private IBackingSensorAPI api;

	public BackingSensor(IBackingSensorAPI _api) {
		api = _api;
	}

	@Override
	public boolean isConfigurable() {
		return api.isLaurinCar();
	}

	@Override
	public boolean isConfigured() {
		return api.hasBackingSensor();
	}

	@Override
	protected void doConfiguration() {
		api.enableBackingSensor();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}
}

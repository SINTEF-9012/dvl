package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.api.IDoubleTrunkAPI;

/**
 * The double trunk feature
 */
public class DoubleTrunk extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("double_trunk");
	private IDoubleTrunkAPI api;

	public DoubleTrunk(IDoubleTrunkAPI _api) {
		api = _api;
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

	@Override
	protected void doConfiguration() {
		api.enableDoubleTrunk();
	}

	@Override
	public boolean isConfigurable() {
		return api.isLaurinCar();
	}

	@Override
	public boolean isConfigured() {
		return api.hasDoubleTrunk();
	}

}

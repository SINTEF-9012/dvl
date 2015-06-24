package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

/**
 * The double trunk feature
 */
public class DoubleTrunk extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("double_trunk");
	protected final ILaurin<?> model;

	public DoubleTrunk(ILaurin<?> _model) {
		model = _model;
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

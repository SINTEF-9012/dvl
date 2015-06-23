package no.sintef.dvl.laurin.core;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

public class Engine140hp extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("hp140");

	public Engine140hp(ILaurin model) {
		super(model);
	}

	@Override
	public boolean isConfigurable() {
		return model.isEngineConfigurable();
	}

	@Override
	public boolean isConfigured() {
		return model.isEngine140hpInsatalled();
	}

	@Override
	protected IFeatureID feature() {
		return FEATURE_ID;
	}

	@Override
	protected void doConfiguration() {
		model.enable140hpEngine();
	}

}

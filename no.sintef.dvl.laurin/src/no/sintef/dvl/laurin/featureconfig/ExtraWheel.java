package no.sintef.dvl.laurin.featureconfig;

import no.sintef.dvl.core.featureid.FeatureIDFacade;
import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.laurin.interfaces.core.ILaurin;

public class ExtraWheel extends LaurinFeature {

	private static final IFeatureID FEATURE_ID = FeatureIDFacade.eINSTANCE.createFeatureID("extra_wheel");
	protected final ILaurin<?> model;

	public ExtraWheel(ILaurin<?> _model) {
		model = _model;
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

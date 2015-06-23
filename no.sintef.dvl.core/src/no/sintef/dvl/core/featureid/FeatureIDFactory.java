package no.sintef.dvl.core.featureid;

import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.core.interfaces.featureid.IFeatureIDFactory;

public class FeatureIDFactory implements IFeatureIDFactory {

	@Override
	public IFeatureID createFeatureID(String name) {
		return new FeatureID(name);
	}

}

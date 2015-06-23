package no.sintef.dvl.core.featureid;

import no.sintef.dvl.core.interfaces.featureid.IFeatureID;
import no.sintef.dvl.core.interfaces.featureid.IFeatureIDFactory;

// TODO: Auto-generated Javadoc
/**
 * An implementation of the factory for creating FeatureID objects.
 */
public class FeatureIDFactory implements IFeatureIDFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.core.interfaces.featureid.IFeatureIDFactory#createFeatureID
	 * (java.lang.String)
	 */
	@Override
	public IFeatureID createFeatureID(String name) {
		return new FeatureID(name);
	}

}

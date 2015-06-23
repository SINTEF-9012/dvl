package no.sintef.dvl.core.featureid;

import no.sintef.dvl.core.interfaces.featureid.IFeatureIDFactory;

public class FeatureIDFacade {

	static public IFeatureIDFactory eINSTANCE = getInstance();

	static private IFeatureIDFactory getInstance() {
		if (eINSTANCE == null)
			eINSTANCE = new FeatureIDFactory();
		return eINSTANCE;
	}

	private FeatureIDFacade() {
	}
}

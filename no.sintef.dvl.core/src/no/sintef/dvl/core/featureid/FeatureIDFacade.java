package no.sintef.dvl.core.featureid;

import no.sintef.dvl.core.interfaces.featureid.IFeatureIDFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class FeatureIDFacade.
 */
public class FeatureIDFacade {

	/** The e instance. */
	static public IFeatureIDFactory eINSTANCE = getInstance();

	/**
	 * Gets the single instance of FeatureIDFacade.
	 *
	 * @return single instance of FeatureIDFacade
	 */
	static private IFeatureIDFactory getInstance() {
		if (eINSTANCE == null)
			new FeatureIDFacade();
		return eINSTANCE;
	}

	/**
	 * Instantiates a new feature id facade.
	 */
	private FeatureIDFacade() {
		eINSTANCE = new FeatureIDFactory();
	}
}

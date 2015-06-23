package no.sintef.dvl.core.interfaces.featureid;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IFeatureID objects.
 */
public interface IFeatureIDFactory {

	/**
	 * Creates a new IFeatureID object.
	 *
	 * @param name
	 *            the name
	 * @return IFeatureID
	 */
	public IFeatureID createFeatureID(String name);
}

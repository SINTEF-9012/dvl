package no.sintef.dvl.core.interfaces.common;

import no.sintef.dvl.core.interfaces.featureid.IFeatureID;

public interface IFeatureConfig {

	/**
	 * Check whether this realization is related to the given feature ID.
	 *
	 * @param feature
	 *            the ID of the feature of interest
	 * @return true if this is the realization of the given feature, false
	 *         otherwise.
	 */
	public boolean relateTo(IFeatureID feature);

	/**
	 * The pre condition of the configuration.
	 *
	 * @return true if the feature is ready to be configured, false otherwise.
	 */
	public boolean isConfigurable();

	/**
	 * Configure the related feature.
	 */
	public void configure();

	/**
	 * The post condition of the configuration.
	 *
	 * @return true if the feature has already been configured, false otherwise.
	 */
	public boolean isConfigured();

}

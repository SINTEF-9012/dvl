package no.sintef.dvl.core.interfaces.common;

public interface IFeatureConfig {

    /**
     * Check whether this realization is related to the given feature ID.
     *
     * @param feature the ID of the feature of interest
     * @return true if this is the realization of the given feature, false
     * otherwise.
     */
    public boolean realize(FeatureID feature);

    public boolean pre();

    public boolean post();

    public void configure();
}

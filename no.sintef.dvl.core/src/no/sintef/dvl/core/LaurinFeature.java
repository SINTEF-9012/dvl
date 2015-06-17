package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public abstract class LaurinFeature implements IFeatureConfig {

    protected final Laurin model;

    public LaurinFeature(Laurin model) {
        this.model = model;
    }

}

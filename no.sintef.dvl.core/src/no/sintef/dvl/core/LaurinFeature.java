package no.sintef.dvl.core;


import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.core.interfaces.common.IFeatureID;

public abstract class LaurinFeature implements IFeatureConfig {

    protected final Laurin model;

    public LaurinFeature(Laurin model) {
        if (model == null) {
            throw new NullPointerException("Invalid laurin car model ('null' found)");
        }
        this.model = model;
    }
    
    @Override
    public final boolean relateTo(IFeatureID feature) {
        return feature.equals(feature());
    }
    
    protected abstract IFeatureID feature();

    @Override
    public final void configure() {
        if (!isConfigurable()) {
            final String description = String.format("The laurin car is not ready for configuring feature '%s'", feature());
            throw new IllegalStateException(description);
        }
        if (!isConfigured()) {
            doConfiguration();
        }
    }

    protected abstract void doConfiguration();
}

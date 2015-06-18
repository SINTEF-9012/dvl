package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public abstract class LaurinFeature implements IFeatureConfig {

    protected final Laurin model;

    public LaurinFeature(Laurin model) {
        if (model == null) {
            throw new NullPointerException("Invalid laurin car model ('null' found)");
        }
        this.model = model;
    }

    @Override
    public final void configure() {
        if (!pre()) {
            throw new IllegalStateException("The laurin car is not ready for configuring feature 'XXX'");
        }
        if (!post()) {
            doConfiguration();
        }
    }

    protected abstract void doConfiguration();
    
    

}

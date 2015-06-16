package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public class ExtraWheel implements IFeatureConfig {

    private final Laurin model;

    public ExtraWheel(Laurin model) {
        assert model != null : "Invalid UML2 model ('null' found)";

        this.model = model;
    }

    @Override
    public boolean pre() {
        return model.hasLaurinCar();
    }

    @Override
    public boolean post() {
       return model.hasExtraWheel();
    }

    @Override
    public void configure() {
        if (!pre()) {
            throw new IllegalStateException("The given model is not ready to configure the feature 'extra wheel'");
        }

        model.enableExtraWheel();
    }

}

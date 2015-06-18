package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.FeatureID;

public class ExtraWheel extends LaurinFeature {

    private static final FeatureID FEATURE_ID = new FeatureID("extra_wheel");

    public ExtraWheel(Laurin model) {
        super(model);
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
    protected void doConfiguration() {
        model.enableExtraWheel();
    }

    @Override
    protected FeatureID feature() {
        return FEATURE_ID;
    }



}

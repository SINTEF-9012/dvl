package no.sintef.dvl.core;

import no.sintef.dvl.common.FeatureID;

/**
 * Realization of the 'ParkAssist' feature
 */
public class ParkAssist extends LaurinFeature {

    private static final FeatureID FEATURE_ID = new FeatureID("park_assist");

    public ParkAssist(Laurin car) {
        super(car);
    }

    @Override
    public boolean isConfigurable() {
        return model.isLaurinCar() && !model.hasBackingSensor();
    }

    @Override
    public boolean isConfigured() {
        return model.hasParkAssist();
    }

    @Override
    protected void doConfiguration() {
        model.enableParkAssist();
    }

    @Override
    protected FeatureID feature() {
        return FEATURE_ID;
    }

}

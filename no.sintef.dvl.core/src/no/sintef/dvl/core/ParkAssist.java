package no.sintef.dvl.core;

/**
 * Realization of the 'ParkAssist' feature
 */
public class ParkAssist extends LaurinFeature {

    public ParkAssist(Laurin car) {
        super(car);
    }

    @Override
    public boolean pre() {
        return model.hasLaurinCar() && !model.hasBackingSensor();
    }

    @Override
    public boolean post() {
        return model.hasParkAssist();
    }

    @Override
    protected void doConfiguration() {
        model.enableParkAssist();
    }

}

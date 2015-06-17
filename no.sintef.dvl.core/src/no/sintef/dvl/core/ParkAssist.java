
package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

/**
 * Realization of the 'ParkAssist' feature
 */
public class ParkAssist implements IFeatureConfig {
    
    private final Laurin car;
    
    public ParkAssist(Laurin car) {
        this.car = car;
    }

    @Override
    public boolean pre() {
        return car.hasLaurinCar() && !car.hasBackingSensor();
    }

    @Override
    public boolean post() {
        return car.hasParkAssist();
    }

    @Override
    public void configure() {
        car.enableParkAssist();
    }
    
}

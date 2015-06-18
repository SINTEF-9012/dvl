
package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.FeatureID;

/**
 * The BackingSensor feature
 */
public class BackingSensor extends LaurinFeature {
        
    public BackingSensor(Laurin car) {
        super(car); 
    }

    @Override
    public boolean pre() {
        return model.hasLaurinCar();
    }

    @Override
    public boolean post() {
       return model.hasBackingSensor();
    }

    @Override
    protected void doConfiguration() {
        model.enableBackingSensor();
    }

    @Override
    protected FeatureID feature() {
        return FEATURE_ID;
    }
    
    private static final FeatureID FEATURE_ID = new FeatureID("backing_sensor");
    
}

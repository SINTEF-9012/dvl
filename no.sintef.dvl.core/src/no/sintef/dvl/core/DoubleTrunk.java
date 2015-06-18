
package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.FeatureID;

/**
 * The double trunk feature
 */
public class DoubleTrunk extends LaurinFeature {

    private static final FeatureID FEATURE_ID = new FeatureID("double_trunk");

    public DoubleTrunk(Laurin model) {
        super(model);
    } 
     
    @Override
    protected FeatureID feature() {
        return FEATURE_ID;
    }

    @Override
    protected void doConfiguration() {
        model.enableDoubleTrunk();
    }

    @Override
    public boolean isConfigurable() {
        return model.isLaurinCar();
    }

    @Override
    public boolean isConfigured() {
        return model.hasDoubleTrunk();
    }
    
}


package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

/**
 * The BackingSensor feature
 */
public class BackingSensor implements IFeatureConfig {
    
    private final Laurin model;
    
    public BackingSensor(Laurin model) {
        this.model = model; 
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
    public void configure() {
        if (!pre()) {
            throw new IllegalStateException("Unable to configure option, the model is not ready for it");
        }
        
        model.enableBackingSensor();
    }
    
}

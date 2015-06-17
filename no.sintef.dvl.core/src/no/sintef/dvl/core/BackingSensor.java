
package no.sintef.dvl.core;

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
    public void configure() {
        if (!pre()) {
            throw new IllegalStateException("Unable to configure option, the model is not ready for it");
        }
        
        model.enableBackingSensor();
    }
    
}

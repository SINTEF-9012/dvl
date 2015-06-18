
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
    protected void doConfiguration() {
        model.enableBackingSensor();
    }
    
}

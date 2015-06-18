package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.common.FeatureID;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public class FeatureConfig implements IFeatureConfig {

    private final String name;
    protected DummyModel model;
    private final ExecutionListener listener;

    public FeatureConfig(String name, DummyModel model, ExecutionListener listener) {
        this.name = name;
        this.model = model;
        this.listener = listener;
    }

    @Override
    public final void configure() {
        performConfiguration();
        listener.onConfigured(name);
    }

    @Override
    public final boolean pre() {
        boolean result = checkReadiness();
        return result;
    }

    @Override
    public final boolean post() {
        boolean result = checkConfiguration();
        return result;
    }

    public boolean checkReadiness() {
        return true;
    }

    public void performConfiguration() {
    }

    public boolean checkConfiguration() {
        return true;
    }

    @Override
    public boolean realize(FeatureID feature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

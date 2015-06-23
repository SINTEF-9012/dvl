package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.core.interfaces.common.IFeatureID;

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
    public final boolean isConfigurable() {
        boolean result = checkReadiness();
        return result;
    }

    @Override
    public final boolean isConfigured() {
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
    public boolean relateTo(IFeatureID feature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

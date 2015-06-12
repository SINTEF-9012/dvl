package no.sintef.dvl.engine.inferfaces.core;

import java.util.List;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public interface IEngine {

    public void run();

    public void setFeatureConfigurators(List<IFeatureConfig> configurators);
}

package no.sintef.dvl.engine;

import java.util.List;
import java.util.function.Function;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.engine.inferfaces.core.IEngine;

/**
 * Run all tasks until completion, or error
 *
 * Error occurs when there are still some tasks to execute, but none are ready.
 */
public class Engine implements IEngine {

    private final Iterator<IFeatureConfig> pendingFeatures;

    public Engine(List<IFeatureConfig> features) {
        this(features, defaultSelection());
    }

    public Engine(List<IFeatureConfig> features, Function<List<IFeatureConfig>, IFeatureConfig> selection) {
        this.pendingFeatures = new Iterator(features, selection);
    }

    /**
     * @return the default selection strategy that drives the order in which
     * active features are configured.
     */
    private static Function<List<IFeatureConfig>, IFeatureConfig> defaultSelection() {
        return (List<IFeatureConfig> items) -> {
            if (items.isEmpty()) {
                return null;
            }
            for (IFeatureConfig anyFeature : items) {
                if (anyFeature.pre()) {
                    return anyFeature;
                }
            }
            return null;
        };
    }

    @Override
    public void run() {
        while (pendingFeatures.hasNext()) {
            IFeatureConfig feature = pendingFeatures.next();
            feature.configure();
            pendingFeatures.remove();
        }
    }

    @Override
    public void setFeatureConfigurators(List<IFeatureConfig> configurators) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

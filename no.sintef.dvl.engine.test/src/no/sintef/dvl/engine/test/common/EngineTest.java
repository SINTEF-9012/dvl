package no.sintef.dvl.engine.test.common;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.engine.Engine;
import no.sintef.dvl.test.dummies.FeatureConfig;
import static no.sintef.dvl.test.dummies.FeatureConfig.CONFIGURE;
import static no.sintef.dvl.test.dummies.FeatureConfig.PRE;

import org.junit.Test;


public class EngineTest {
    
    @Test
    public void shouldConfigureASingleFeature() {
        FeatureConfig config = new FeatureConfig(true);
      
        List<IFeatureConfig> confs = Arrays.asList(config);

        Engine engine = new Engine(confs);
        engine.run();

        assertTrue(config.wasInvoked(PRE));
        assertTrue(config.wasInvoked(CONFIGURE));
    }
    
    
    @Test
    public void shouldNotConfigureAFeatureWhichIsNotReady() {
        FeatureConfig config = new FeatureConfig(false);
      
        List<IFeatureConfig> confs = Arrays.asList(config);

        Engine engine = new Engine(confs);
        engine.run();

        assertTrue(config.wasInvoked(PRE));
        assertFalse(config.wasInvoked(CONFIGURE));
    }
    
}

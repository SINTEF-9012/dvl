package no.sintef.dvl.engine.test.common;

import static org.junit.Assert.*;

import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javax.swing.text.html.HTML.Tag.PRE;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.engine.Engine;
import no.sintef.dvl.test.dummies.DummyModel;
import no.sintef.dvl.test.dummies.ExecutionListener;
import no.sintef.dvl.test.dummies.FeatureConfig;
import org.jmock.Mockery;

import org.junit.Test;

public class EngineTest {

    private Mockery context = new Mockery();

    @Test
    public void shouldConfigureASingleFeature() {
        final OrderChecker trace = new OrderChecker();

        FeatureConfig feature = new FeatureConfig("featureA", new DummyModel(), trace);

        Engine engine = new Engine(asList(feature));
        engine.run();

        assertTrue(trace.wasConfigured("featureA"));
    }

    @Test
    public void shouldNotConfigureAFeatureWhichIsNotReady() {
        final OrderChecker trace = new OrderChecker();

        FeatureConfig feature = new FeatureConfig("featureA", new DummyModel(), trace) {
            @Override
            public boolean checkReadiness() {
                return false;
            }
        };

        Engine engine = new Engine(asList(feature));
        engine.run();

        assertFalse(trace.wasConfigured("featureA"));
    }

    @Test
    public void testBidon() {

        final OrderChecker trace = new OrderChecker();

        DummyModel model = new DummyModel();

        FeatureConfig featureA = new FeatureConfig("featureA", model, trace) {

            @Override
            public void performConfiguration() {
                model.set("v1", 3);
            }

        };

        FeatureConfig featureB = new FeatureConfig("featureB", model, trace) {

            @Override
            public boolean checkReadiness() {
                return model.get("v1") == 3;
            }

        };

        Engine engine = new Engine(asList(featureA, featureB));
        engine.run();

        assertTrue(trace.wasConfigured("featureA"));
        assertTrue(trace.wasConfigured("featureB"));
        assertTrue(trace.order("featureA", "featureB"));
    }

    
    private static class OrderChecker implements ExecutionListener {

        private int clock;
        private Map<String, Integer> events;

        public OrderChecker() {
            clock = 0;
            events = new HashMap<>();
        }

        @Override
        public void onConfigured(String featureId) {
            events.put(featureId, clock);
            clock++;
        }

        public boolean wasConfigured(String feature) {
            return events.containsKey(feature);
        }

        public boolean order(String first, String second) {
            return events.get(first) < events.get(second);
        }

    }

}

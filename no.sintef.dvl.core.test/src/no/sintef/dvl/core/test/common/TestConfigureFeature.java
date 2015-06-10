package no.sintef.dvl.core.test.common;

import static org.junit.Assert.*;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.core.interfaces.common.IFeatureConfigurator;
import no.sintef.dvl.core.interfaces.common.IExecutionResult;
import no.sintef.dvl.test.dummies.DummyCommandConfig;
import no.sintef.dvl.test.dummies.DummyCommandPost;
import no.sintef.dvl.test.dummies.DummyCommandPre;
import no.sintef.dvl.test.dummies.DummyExeResult;
import no.sintef.dvl.test.dummies.FeatureConfigurator;
import no.sintef.dvl.test.dummies.FeatureConfig;

import org.junit.Test;

public class TestConfigureFeature {

	@Test
	public void test() {
		
		IFeatureConfig config = new FeatureConfig(new DummyCommandConfig(), new DummyCommandPre(), new DummyCommandPost());
		IFeatureConfigurator configurator = new FeatureConfigurator(config);
		
		IExecutionResult<?, ?, ?> result = new DummyExeResult();
		configurator.test(result);
		
		assertEquals("pre_result", result.getPreResult());
		assertEquals("post_result", result.getPostResult());
		assertEquals("config_result", result.getConfigResult());
	}
	
}

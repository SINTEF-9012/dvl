package no.sintef.dvl.engine.test.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.core.interfaces.common.IFeatureConfigurator;
import no.sintef.dvl.core.interfaces.common.IExecutionResult;
import no.sintef.dvl.engine.inferfaces.core.IEngine;
import no.sintef.dvl.test.dummies.DummyCommandConfig;
import no.sintef.dvl.test.dummies.DummyCommandPost;
import no.sintef.dvl.test.dummies.DummyCommandPre;
import no.sintef.dvl.test.dummies.DummyExeResult;
import no.sintef.dvl.test.dummies.FeatureConfig;
import no.sintef.dvl.test.dummies.FeatureConfigurator;

import org.junit.Test;

public class TestExecuteEngine {

	@Test
	public void test() {
		IEngine engine = new DummyEngine();
		IFeatureConfig config = new FeatureConfig(new DummyCommandConfig(), new DummyCommandPre(), new DummyCommandPost());
		IFeatureConfigurator configurator = new FeatureConfigurator(config);
		
		List<IFeatureConfigurator> confs = new ArrayList<IFeatureConfigurator>();
		confs.add(configurator);
		
		engine.setFeatureConfigurators(confs);
		engine.run();
		
		assertEquals(configurator, ((DummyEngine) engine).configResult.keySet().iterator().next());
		
	}

	
	public class DummyEngine implements IEngine {

		public List<IFeatureConfigurator> conifurators;
		public Map<IFeatureConfigurator, IExecutionResult> configResult;

		@Override
		public void run() {
			configResult = new HashMap<IFeatureConfigurator, IExecutionResult>();
			for(IFeatureConfigurator conf : conifurators) {
				IExecutionResult result = new DummyExeResult();
				conf.test(result);
				configResult.put(conf, result);
			}
			
		}

		@Override
		public void setFeatureConfigurators(
				List<IFeatureConfigurator> _configurators) {
			conifurators = _configurators;
		}
		
	}
}

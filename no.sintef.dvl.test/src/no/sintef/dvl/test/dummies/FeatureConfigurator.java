package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.common.IExecutionResult;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import no.sintef.dvl.core.interfaces.common.IFeatureConfigurator;

public class FeatureConfigurator implements IFeatureConfigurator {

	IFeatureConfig config;
	
	public FeatureConfigurator(IFeatureConfig _config) {
		config = _config;
	}
	
	@Override
	public void test(IExecutionResult<?, ?, ?> result) {
		if (config.pre(result)) {
			config.configure(result);
			config.post(result);
		}
	}
}
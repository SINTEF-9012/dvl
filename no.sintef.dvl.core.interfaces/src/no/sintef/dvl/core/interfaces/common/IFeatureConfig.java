package no.sintef.dvl.core.interfaces.common;

public interface IFeatureConfig {

	public boolean pre(IExecutionResult<?, ?, ?> result);
	
	public boolean post(IExecutionResult<?, ?, ?> result);
	
	public void configure(IExecutionResult<?, ?, ?> result);
}

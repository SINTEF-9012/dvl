package no.sintef.dvl.core.interfaces.common;

public interface IExecutionResult<PRE_R, POST_R, CONFIG_R> {

	public PRE_R getPreResult();
	
	public POST_R getPostResult();
	
	public CONFIG_R getConfigResult();
}

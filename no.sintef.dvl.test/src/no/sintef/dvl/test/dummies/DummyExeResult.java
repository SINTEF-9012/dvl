package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.common.IExecutionResult;

public class DummyExeResult implements IExecutionResult<String, String, String> {

	private String pre_result;
	private String post_result;
	private String config_result;

	@Override
	public String getPreResult() {
		return pre_result;
	}
	
	public void setPreResult(String result) {
		pre_result = result;
	}

	@Override
	public String getPostResult() {
		return post_result;
	}
	
	public void setPostResult(String result) {
		post_result = result;
	}

	@Override
	public String getConfigResult() {
		return config_result;
	}
	
	public void setConfigResult(String result) {
		config_result = result;
	}
}

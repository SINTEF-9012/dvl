package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.command.ICommand;
import no.sintef.dvl.core.interfaces.common.IExecutionResult;
import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public class FeatureConfig implements IFeatureConfig {

	private ICommand command;
	private ICommand command_pre;
	private ICommand command_post;

	public FeatureConfig(ICommand _config_command, ICommand _command_pre, ICommand _command_post) {
		command = _config_command;
		command_pre = _command_pre;
		command_post = _command_post;
	}
	
	@Override
	public void configure(IExecutionResult<?, ?, ?> result) {
		command.setResult(result);
		command.execute();
	}

	@Override
	public boolean pre(IExecutionResult<?, ?, ?> result) {
		command_pre.setResult(result);
		command_pre.execute();
		return true;
	}

	@Override
	public boolean post(IExecutionResult<?, ?, ?> result) {
		command_post.setResult(result);
		command_post.execute();
		return true;
	}
}

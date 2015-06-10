package no.sintef.dvl.core.interfaces.command;

import no.sintef.dvl.core.interfaces.common.IExecutionResult;

public interface ICommand {
	
	public void execute();
	
	public IExecutionResult<?, ?, ?> getResult();
	
	public void setResult(IExecutionResult<?, ?, ?> result);
}

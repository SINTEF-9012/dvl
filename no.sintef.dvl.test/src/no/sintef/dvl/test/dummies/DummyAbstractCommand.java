package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.command.ICommand;
import no.sintef.dvl.core.interfaces.common.IExecutionResult;


public abstract class DummyAbstractCommand implements ICommand {
	
	protected IExecutionResult<?, ?, ?> result;
	
	@Override
	public void setResult(IExecutionResult<?, ?, ?> _result) {
		result = _result;
	}
	
	@Override
	public IExecutionResult<?, ?, ?> getResult() {
		return result;
	}
}

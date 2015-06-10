package no.sintef.dvl.test.dummies;

public class DummyCommandConfig extends DummyAbstractCommand {

	@Override
	public void execute() {
		((DummyExeResult) result).setConfigResult("config_result");
		
	}	
}
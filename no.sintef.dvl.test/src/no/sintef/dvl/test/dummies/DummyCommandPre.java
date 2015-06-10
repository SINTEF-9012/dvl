package no.sintef.dvl.test.dummies;

public class DummyCommandPre extends DummyAbstractCommand {

	@Override
	public void execute() {
		((DummyExeResult) result).setPreResult("pre_result");
		
	}	
}

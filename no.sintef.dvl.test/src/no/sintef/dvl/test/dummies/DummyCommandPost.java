package no.sintef.dvl.test.dummies;

public class DummyCommandPost extends DummyAbstractCommand {

	@Override
	public void execute() {
		((DummyExeResult) result).setPostResult("post_result");
		
	}	
}

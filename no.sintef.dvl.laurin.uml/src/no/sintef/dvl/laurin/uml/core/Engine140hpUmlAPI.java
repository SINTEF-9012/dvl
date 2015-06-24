package no.sintef.dvl.laurin.uml.core;

import no.sintef.dvl.laurin.interfaces.core.IEngine140hpAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;

public class Engine140hpUmlAPI implements IEngine140hpAPI {

	private Model laurin;

	private final String BASE_ENGINE_CLASS = "Engine";
	private final String BASE_ENGINE_PROPERTY = "engine";
	private final String BASE_ENGINE_HP140_CLASS = "hp140";

	public Engine140hpUmlAPI(Model _laurin) {
		laurin = _laurin;
	}

	public boolean isEngineConfigurable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void enable140hpEngine() {
		// TODO Auto-generated method stub

	}

	public boolean isEngine140hpInsatalled() {
		Package base = Utilities.findLaurinBasePackage(laurin);
		Class klass = Utilities.findClassIn(base, BASE_ENGINE_HP140_CLASS);
		return Utilities.hasExtra(laurin, BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY) && klass != null;
	}

}

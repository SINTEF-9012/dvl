package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IEngine140hpAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;

// TODO: Auto-generated Javadoc
/**
 * The Class Engine140hpAPIUML.
 */
public class Engine140hpAPIUML implements IEngine140hpAPI {

	/** The laurin. */
	private Model laurin;

	/** The base engine class. */
	private final String BASE_ENGINE_CLASS = "Engine";

	/** The base engine property. */
	private final String BASE_ENGINE_PROPERTY = "engine";

	/** The BAS e_ engin e_ h p140_ class. */
	private final String BASE_ENGINE_HP140_CLASS = "hp140";

	/**
	 * Instantiates a new engine140hp apiuml.
	 *
	 * @param _laurin
	 *            the _laurin
	 */
	public Engine140hpAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IEngine140hpAPI#isEngineConfigurable
	 * ()
	 */
	public boolean isEngineConfigurable() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IEngine140hpAPI#enable140hpEngine()
	 */
	public void enable140hpEngine() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IEngine140hpAPI#isEngine140hpInsatalled
	 * ()
	 */
	public boolean isEngine140hpInsatalled() {
		Package base = Utilities.findLaurinBasePackage(laurin);
		Class klass = Utilities.findClassIn(base, BASE_ENGINE_HP140_CLASS);
		return Utilities.hasExtra(laurin, BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY) && klass != null;
	}

}

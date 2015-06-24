package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IEngine110hpAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;

// TODO: Auto-generated Javadoc
/**
 * The Class Engine140hpAPIUML.
 */
public class Engine110hpAPIUML implements IEngine110hpAPI {

	/** The laurin. */
	private Model laurin;

	/** The base engine class. */
	private final String BASE_ENGINE_CLASS = "Engine";

	/** The base engine property. */
	private final String BASE_ENGINE_PROPERTY = "engine";

	/** The BAS e_ engin e_ h p140_ class. */
	private final String BASE_ENGINE_HP110_CLASS = "hp110";

	/**
	 * Instantiates a new engine140hp apiuml.
	 *
	 * @param _laurin
	 *            the _laurin
	 */
	public Engine110hpAPIUML(Model _laurin) {
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
		Package base = Utilities.findLaurinBasePackage(laurin);
		if (base == null)
			return false;

		Class klass = Utilities.findClassIn(base, BASE_ENGINE_CLASS);
		return Utilities.hasExtra(laurin, BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY) && klass != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IEngine140hpAPI#enable140hpEngine()
	 */
	public void enable110hpEngine() {
		Package base = Utilities.findLaurinBasePackage(laurin);
		Class klass = Utilities.createClass(base, BASE_ENGINE_HP110_CLASS);
		Class baseKlass = Utilities.findClassIn(base, BASE_ENGINE_CLASS);
		klass.createGeneralization(baseKlass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IEngine140hpAPI#isEngine140hpInsatalled
	 * ()
	 */
	public boolean isEngine110hpInsatalled() {
		Package base = Utilities.findLaurinBasePackage(laurin);
		Class klass = Utilities.findClassIn(base, BASE_ENGINE_HP110_CLASS);
		return Utilities.hasExtra(laurin, BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY) && klass != null;
	}


}

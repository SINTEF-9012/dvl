package no.sintef.dvl.laurin.uml.core;

import no.sintef.dvl.laurin.interfaces.core.ILaurin;

import org.eclipse.uml2.uml.Model;

/**
 * Wrapper class which holds Laurin model models.
 *
 */
public class Laurin<MODEL> implements ILaurin<MODEL> {

	private Model laurin;

	public Laurin(Model umlModel) {
		laurin = umlModel;
	}

	public MODEL getLaurinModel() {
		return (MODEL) laurin;
	}
}

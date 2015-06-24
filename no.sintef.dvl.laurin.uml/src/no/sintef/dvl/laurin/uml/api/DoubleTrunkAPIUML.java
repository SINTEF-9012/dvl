package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IDoubleTrunkAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;

// TODO: Auto-generated Javadoc
/**
 * The Class DoubleTrunkAPIUML.
 */
public class DoubleTrunkAPIUML implements IDoubleTrunkAPI {

	/** The laurin. */
	private Model laurin;

	/** The double trunk class. */
	private final String DOUBLE_TRUNK_CLASS = "DoubleTrunk";

	/** The double trunk property. */
	private final String DOUBLE_TRUNK_PROPERTY = "doubleTrunk";

	/**
	 * Instantiates a new double trunk apiuml.
	 *
	 * @param _laurin
	 *            the _laurin
	 */
	public DoubleTrunkAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IDoubleTrunkAPI#isLaurinCar()
	 */
	@Override
	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IDoubleTrunkAPI#enableDoubleTrunk()
	 */
	@Override
	public void enableDoubleTrunk() {
		Utilities.enableExtra(laurin, DOUBLE_TRUNK_CLASS, DOUBLE_TRUNK_PROPERTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IDoubleTrunkAPI#hasDoubleTrunk()
	 */
	@Override
	public boolean hasDoubleTrunk() {
		return Utilities.hasExtra(laurin, DOUBLE_TRUNK_CLASS, DOUBLE_TRUNK_PROPERTY);
	}

}

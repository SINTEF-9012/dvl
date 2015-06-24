package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IBackingSensorAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;

// TODO: Auto-generated Javadoc
/**
 * The Class BackingSensorAPIUML.
 */
public class BackingSensorAPIUML implements IBackingSensorAPI {

	/** The laurin. */
	private Model laurin;

	/** The backing sensor class. */
	private final String BACKING_SENSOR_CLASS = "BackingSensor";

	/** The backing sensor property. */
	private final String BACKING_SENSOR_PROPERTY = "backingSensor";

	/**
	 * Instantiates a new backing sensor apiuml.
	 *
	 * @param _laurin
	 *            the _laurin
	 */
	public BackingSensorAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IBackingSensorAPI#hasBackingSensor()
	 */
	@Override
	public boolean hasBackingSensor() {
		return Utilities.hasExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IBackingSensorAPI#enableBackingSensor
	 * ()
	 */
	@Override
	public void enableBackingSensor() {
		Utilities.enableExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IBackingSensorAPI#isLaurinCar()
	 */
	@Override
	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

}

package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkAssistAPIUML.
 */
public class ParkAssistAPIUML implements IParkAssistAPI {

	/** The laurin. */
	private Model laurin;

	/** The parking assist class. */
	private final String PARKING_ASSIST_CLASS = "ParkingAssist";

	/** The parking assist property. */
	private final String PARKING_ASSIST_PROPERTY = "parkingAssist";

	/** The backing sensor class. */
	private final String BACKING_SENSOR_CLASS = "BackingSensor";

	/** The backing sensor property. */
	private final String BACKING_SENSOR_PROPERTY = "backingSensor";

	/**
	 * Instantiates a new park assist apiuml.
	 *
	 * @param _laurin
	 *            the _laurin
	 */
	public ParkAssistAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI#enableParkAssist()
	 */
	@Override
	public void enableParkAssist() {
		Utilities.enableExtra(laurin, PARKING_ASSIST_CLASS, PARKING_ASSIST_PROPERTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI#hasParkAssist()
	 */
	@Override
	public boolean hasParkAssist() {
		return Utilities.hasExtra(laurin, PARKING_ASSIST_CLASS, PARKING_ASSIST_PROPERTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI#isLaurinCar()
	 */
	@Override
	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IParkAssistAPI#hasBackingSensor()
	 */
	@Override
	public boolean hasBackingSensor() {
		return Utilities.hasExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

}

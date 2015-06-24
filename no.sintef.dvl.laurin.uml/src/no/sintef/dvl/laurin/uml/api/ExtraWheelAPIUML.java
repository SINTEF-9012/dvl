package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IExtraWheelAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtraWheelAPIUML.
 */
public class ExtraWheelAPIUML implements IExtraWheelAPI {

	/** The laurin. */
	private Model laurin;

	/** The extra wheel class. */
	private final String EXTRA_WHEEL_CLASS = "ExtraWheel";

	/** The extra wheel property. */
	private final String EXTRA_WHEEL_PROPERTY = "extraWheel";

	/**
	 * Instantiates a new extra wheel apiuml.
	 *
	 * @param _laurin
	 *            the _laurin
	 */
	public ExtraWheelAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IExtraWheelAPI#hasExtraWheel()
	 */
	@Override
	public boolean hasExtraWheel() {
		return Utilities.hasExtra(laurin, EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.dvl.laurin.interfaces.api.IExtraWheelAPI#enableExtraWheel()
	 */
	@Override
	public void enableExtraWheel() {
		Utilities.enableExtra(laurin, EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.dvl.laurin.interfaces.api.IExtraWheelAPI#isLaurinCar()
	 */
	@Override
	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

}

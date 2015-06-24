package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IBackingSensorAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;

public class BackingSensorAPIUML implements IBackingSensorAPI {

	private Model laurin;

	private final String BACKING_SENSOR_CLASS = "BackingSensor";
	private final String BACKING_SENSOR_PROPERTY = "backingSensor";

	public BackingSensorAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	@Override
	public boolean hasBackingSensor() {
		return Utilities.hasExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	@Override
	public void enableBackingSensor() {
		Utilities.enableExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	@Override
	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

}

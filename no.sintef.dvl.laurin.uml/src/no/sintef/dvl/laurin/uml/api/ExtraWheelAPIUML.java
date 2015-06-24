package no.sintef.dvl.laurin.uml.api;

import no.sintef.dvl.laurin.interfaces.api.IExtraWheelAPI;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.uml2.uml.Model;

public class ExtraWheelAPIUML implements IExtraWheelAPI {

	private Model laurin;
	private final String EXTRA_WHEEL_CLASS = "ExtraWheel";
	private final String EXTRA_WHEEL_PROPERTY = "extraWheel";

	public ExtraWheelAPIUML(Model _laurin) {
		laurin = _laurin;
	}

	@Override
	public boolean hasExtraWheel() {
		return Utilities.hasExtra(laurin, EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);
	}

	@Override
	public void enableExtraWheel() {
		Utilities.enableExtra(laurin, EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);

	}

	@Override
	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

}

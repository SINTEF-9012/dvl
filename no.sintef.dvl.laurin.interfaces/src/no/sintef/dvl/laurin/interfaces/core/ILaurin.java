package no.sintef.dvl.laurin.interfaces.core;

/**
 * Provides an API that helps manipulating Laurin car
 *
 */
public interface ILaurin {

	public boolean hasBackingSensor();

	public void enableBackingSensor();

	public boolean hasExtraWheel();

	public void enableParkAssist();

	public boolean hasParkAssist();

	public void enableExtraWheel();

	public boolean isLaurinCar();

	public void enableDoubleTrunk();

	public boolean hasDoubleTrunk();

	public boolean isEngineConfigurable();

	public void enable140hpEngine();

	public boolean isEngine140hpInsatalled();

}

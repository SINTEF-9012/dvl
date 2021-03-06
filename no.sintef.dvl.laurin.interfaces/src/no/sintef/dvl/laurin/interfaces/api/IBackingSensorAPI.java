package no.sintef.dvl.laurin.interfaces.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBackingSensorAPI provides api manipulate backing sensor.
 */
public interface IBackingSensorAPI {

	/**
	 * Checks if is laurin car.
	 *
	 * @return true, if is laurin car
	 */
	public boolean isLaurinCar();

	/**
	 * Checks for backing sensor.
	 *
	 * @return true, if successful
	 */
	public boolean hasBackingSensor();

	/**
	 * Enable backing sensor.
	 */
	public void enableBackingSensor();
}

package no.sintef.dvl.laurin.interfaces.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface IParkAssistAPI provides API to manipulate on park assist.
 */
public interface IParkAssistAPI {

	/**
	 * Enable park assist.
	 */
	public void enableParkAssist();

	/**
	 * Checks for park assist.
	 *
	 * @return true, if successful
	 */
	public boolean hasParkAssist();

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
}

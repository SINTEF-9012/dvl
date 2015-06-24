package no.sintef.dvl.laurin.interfaces.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExtraWheelAPI which provides API to manipulate on extra wheel
 * functionality.
 */
public interface IExtraWheelAPI {

	/**
	 * Checks for extra wheel.
	 *
	 * @return true, if successful
	 */
	public boolean hasExtraWheel();

	/**
	 * Enable extra wheel.
	 */
	public void enableExtraWheel();

	/**
	 * Checks if is laurin car.
	 *
	 * @return true, if is laurin car
	 */
	public boolean isLaurinCar();
}

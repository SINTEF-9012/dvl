package no.sintef.dvl.laurin.interfaces.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDoubleTrunkAPI provides api to manipulate double truck.
 */
public interface IDoubleTrunkAPI {

	/**
	 * Checks if is laurin car.
	 *
	 * @return true, if is laurin car
	 */
	public boolean isLaurinCar();

	/**
	 * Enable double trunk.
	 */
	public void enableDoubleTrunk();

	/**
	 * Checks for double trunk.
	 *
	 * @return true, if successful
	 */
	public boolean hasDoubleTrunk();
}

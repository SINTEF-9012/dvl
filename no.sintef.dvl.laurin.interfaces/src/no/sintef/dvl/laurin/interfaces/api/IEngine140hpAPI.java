package no.sintef.dvl.laurin.interfaces.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface IEngine140hpAPI which provides api to operate on engine.
 */
public interface IEngine140hpAPI {

	/**
	 * Checks if is engine configurable.
	 *
	 * @return true, if is engine configurable
	 */
	public boolean isEngineConfigurable();

	/**
	 * Enable140hp engine.
	 */
	public void enable140hpEngine();

	/**
	 * Checks if is engine140hp insatalled.
	 *
	 * @return true, if is engine140hp insatalled
	 */
	public boolean isEngine140hpInsatalled();
}

package no.sintef.dvl.laurin.uml.core;

import no.sintef.dvl.laurin.interfaces.core.ILaurin;
import no.sintef.dvl.laurin.uml.tools.Utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Wrapper class which provides an API that helps manipulating Laurin car
 * models.
 *
 * Mainly extracted from observing duplicated code in both features realization
 * and tests
 */
public class Laurin<MODEL> implements ILaurin<MODEL> {

	private Model laurin;

	public Laurin(Model umlModel) {
		laurin = umlModel;
	}

	public boolean hasBackingSensor() {
		return Utilities.hasExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	public void enableBackingSensor() {
		Utilities.enableExtra(laurin, BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	public boolean hasExtraWheel() {
		return Utilities.hasExtra(laurin, EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);
	}


	public void enableParkAssist() {
		Utilities.enableExtra(laurin, PARKING_ASSIST_CLASS, PARKING_ASSIST_PROPERTY);
	}

	public boolean hasParkAssist() {
		return Utilities.hasExtra(laurin, PARKING_ASSIST_CLASS, PARKING_ASSIST_PROPERTY);
	}

	public void enableExtraWheel() {
		Utilities.enableExtra(laurin, EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);
	}

	public boolean isLaurinCar() {
		return Utilities.findLaurinClass(laurin) != null;
	}

	/**
	 * Load and wrap the model given as parameter
	 *
	 * @param path
	 *            the path to the model to wrap
	 * @return a wrapped model, which extended capabilities
	 */
	public static Laurin loadFrom(String path) {
		UMLPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(path), true);

		Model model = (Model) resource.getContents().get(0);
		return from(model);
	}

	/**
	 * Wrap the given model into a Laurin adapter with extended capabilities
	 *
	 * @param model
	 *            the UML2 model to wrap
	 * @return the Laurin object
	 */
	public static Laurin from(Model model) {
		return new Laurin(model);
	}

	private static final String LAURIN_CLASS_NAME = "Laurin";
	private static final String BACKING_SENSOR_CLASS = "BackingSensor";
	private static final String BACKING_SENSOR_PROPERTY = "backingSensor";
	private static final String PARKING_ASSIST_CLASS = "ParkingAssist";
	private static final String PARKING_ASSIST_PROPERTY = "parkingAssist";
	private static final String EXTRA_WHEEL_CLASS = "ExtraWheel";
	private static final String EXTRA_WHEEL_PROPERTY = "extraWheel";
	private static final String BASE_PACKAGE = "Base";
	private static final String BASE_ENGINE_CLASS = "Engine";
	private static final String BASE_ENGINE_PROPERTY = "engine";
	private static final String BASE_ENGINE_HP140_CLASS = "hp140";

	public void enableDoubleTrunk() {
		Utilities.enableExtra(laurin, "DoubleTrunk", "doubleTrunk");
	}

	public boolean hasDoubleTrunk() {
		return Utilities.hasExtra(laurin, "DoubleTrunk", "doubleTrunk");
	}

	public boolean isEngineConfigurable() {
		return Utilities.hasExtra(laurin, BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY);
	}

	public void enable140hpEngine() {
		// TODO Auto-generated method stub
	}

	public boolean isEngine140hpInsatalled() {
		Package base = Utilities.findLaurinBasePackage(laurin);
		Class klass = Utilities.findClassIn(base, BASE_ENGINE_HP140_CLASS);
		return Utilities.hasExtra(laurin, BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY) && klass != null;
	}

	public MODEL getLaurinModel() {
		return (MODEL) laurin;
	}
}

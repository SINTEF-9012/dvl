package no.sintef.dvl.laurin.uml.core;

import no.sintef.dvl.laurin.interfaces.core.ILaurin;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Wrapper class which provides an API that helps manipulating Laurin car
 * models.
 *
 * Mainly extracted from observing duplicated code in both features realization
 * and tests
 */
public class Laurin implements ILaurin {

	private Model laurin;
	private UMLFactory factory;

	private Laurin(Model umlModel) {
		this.factory = UMLFactory.eINSTANCE;
		this.laurin = umlModel;
	}

	public boolean hasBackingSensor() {
		return hasExtra(BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	public void enableBackingSensor() {
		enableExtra(BACKING_SENSOR_CLASS, BACKING_SENSOR_PROPERTY);
	}

	private void enableExtra(String className, String propertyName) {
		org.eclipse.uml2.uml.Package base = findBasePackage();
		assert base != null : "No base package";

		org.eclipse.uml2.uml.Class theClass = createClass(base, className);
		org.eclipse.uml2.uml.Class laurin = findClassIn(base, LAURIN_CLASS_NAME);
		createProperty(laurin, propertyName, theClass);
	}

	public boolean hasExtraWheel() {
		return hasExtra(EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);
	}

	private boolean hasExtra(String className, String propertyName) {
		org.eclipse.uml2.uml.Class laurinClass = findLaurinClass();
		if (laurinClass == null) {
			return false;
		}

		org.eclipse.uml2.uml.Package base = findBasePackage();
		if (base == null) {
			return false;
		}

		org.eclipse.uml2.uml.Class klass = findClassIn(base, className);
		if (klass == null) {
			return false;
		}

		return laurinClass.getAttribute(propertyName, klass) != null;
	}

	public void enableParkAssist() {
		enableExtra(PARKING_ASSIST_CLASS, PARKING_ASSIST_PROPERTY);
	}

	public boolean hasParkAssist() {
		return hasExtra(PARKING_ASSIST_CLASS, PARKING_ASSIST_PROPERTY);
	}

	public void enableExtraWheel() {
		enableExtra(EXTRA_WHEEL_CLASS, EXTRA_WHEEL_PROPERTY);
	}

	private org.eclipse.uml2.uml.Class findLaurinClass() {
		org.eclipse.uml2.uml.Package base = findBasePackage();
		if (base == null) {
			return null;
		}
		return findClassIn(base, LAURIN_CLASS_NAME);
	}

	private org.eclipse.uml2.uml.Class createClass(org.eclipse.uml2.uml.Package thePackage, String className) {
		org.eclipse.uml2.uml.Class theClass = factory.createClass();
		theClass.setName(className);
		thePackage.getPackagedElements().add(theClass);
		return theClass;
	}

	private void createProperty(org.eclipse.uml2.uml.Class theClass, String propertyName, org.eclipse.uml2.uml.Type theType) {
		Property theProperty = factory.createProperty();
		theProperty.setName(propertyName);
		theProperty.setType(theType);
		theClass.getOwnedAttributes().add(theProperty);
	}

	private org.eclipse.uml2.uml.Class findClassIn(org.eclipse.uml2.uml.Package base, String className) {
		assert base != null : "Invalid base package ('null' found)";
		Classifier theclass = (Classifier) base.getPackagedElement(className);
		return (org.eclipse.uml2.uml.Class) theclass;
	}

	private org.eclipse.uml2.uml.Package findBasePackage() {
		return (org.eclipse.uml2.uml.Package) laurin.getPackagedElement(BASE_PACKAGE);
	}

	public boolean isLaurinCar() {
		return findLaurinClass() != null;
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
		enableExtra("DoubleTrunk", "doubleTrunk");
	}

	public boolean hasDoubleTrunk() {
		return hasExtra("DoubleTrunk", "doubleTrunk");
	}

	public boolean isEngineConfigurable() {
		return hasExtra(BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY);
	}

	public void enable140hpEngine() {
		// TODO Auto-generated method stub
	}

	public boolean isEngine140hpInsatalled() {
		Package base = findBasePackage();
		Class klass = findClassIn(base, BASE_ENGINE_HP140_CLASS);
		return hasExtra(BASE_ENGINE_CLASS, BASE_ENGINE_PROPERTY) && klass != null;
	}
}

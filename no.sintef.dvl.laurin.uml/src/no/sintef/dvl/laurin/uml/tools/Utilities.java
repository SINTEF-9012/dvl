package no.sintef.dvl.laurin.uml.tools;

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
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


public class Utilities {

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

	public static Package findLaurinBasePackage(Model laurin) {
		return (Package) laurin.getPackagedElement(BASE_PACKAGE);
	}

	public static Class findLaurinClass(Model laurin) {
		Package base = Utilities.findLaurinBasePackage(laurin);
		if (base == null) {
			return null;
		}
		return Utilities.findClassIn(base, LAURIN_CLASS_NAME);
	}

	public static Class findClassIn(Package base, String className) {
		assert base != null : "Invalid base package ('null' found)";
		Classifier theclass = (Classifier) base.getPackagedElement(className);
		return (Class) theclass;
	}

	public static boolean hasExtra(Model laurin, String className, String propertyName) {
		Class laurinClass = Utilities.findLaurinClass(laurin);
		if (laurinClass == null) {
			return false;
		}

		Package base = Utilities.findLaurinBasePackage(laurin);
		if (base == null) {
			return false;
		}

		Class klass = findClassIn(base, className);
		if (klass == null) {
			return false;
		}

		return laurinClass.getAttribute(propertyName, klass) != null;
	}

	public static void enableExtra(Model laurin, String className, String propertyName) {
		org.eclipse.uml2.uml.Package base = Utilities.findLaurinBasePackage(laurin);
		assert base != null : "No base package";

		Class theClass = Utilities.createClass(base, className);
		Class laurinClass = Utilities.findClassIn(base, LAURIN_CLASS_NAME);
		Utilities.createProperty(laurinClass, propertyName, theClass);
	}
	
	public static Class createClass(Package thePackage, String className) {
		org.eclipse.uml2.uml.Class theClass = UMLFactory.eINSTANCE.createClass();
		theClass.setName(className);
		thePackage.getPackagedElements().add(theClass);
		return theClass;
	}

	public static void createProperty(Class theClass, String propertyName, Type theType) {
		Property theProperty = UMLFactory.eINSTANCE.createProperty();
		theProperty.setName(propertyName);
		theProperty.setType(theType);
		theClass.getOwnedAttributes().add(theProperty);
	}

	public static Model loadLaurinModelFrom(String path) {
		UMLPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(path), true);

		Model model = (Model) resource.getContents().get(0);
		return model;
	}

}

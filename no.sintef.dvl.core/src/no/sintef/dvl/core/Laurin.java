package no.sintef.dvl.core;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Wrapper class which provides an API that helps manipulating Laurin models.
 *
 * Mainly extracted from observing duplicated code in both features realization
 * and tests
 */
public class Laurin {

    private final Model laurin;
    private UMLFactory factory;

    private Laurin(Model umlModel) {
        this.factory = UMLFactory.eINSTANCE;
        this.laurin = umlModel;
    }

    private org.eclipse.uml2.uml.Class findLaurinClass() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        if (base == null) {
            return null;
        }
        return findClassIn(base, LAURIN_CLASS_NAME);
    }

    private org.eclipse.uml2.uml.Class findBackingSensor() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        if (base == null) {
            return null;
        }
        return findClassIn(base, BACKING_SENSOR_CLASS);
    }

    public boolean hasBackingSensor() {
        org.eclipse.uml2.uml.Class laurin = findLaurinClass();
        if (laurin == null) {
            return false;
        }
        org.eclipse.uml2.uml.Class backingSensor = findBackingSensor();
        if (backingSensor == null) {
            return false;
        }
        Property backingSensorProperty = laurin.getAttribute(BACKING_SENSOR_PROPERTY, backingSensor);
        return backingSensorProperty != null;
    }

    public void enableBackingSensor() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        assert base != null : "No base package";
        org.eclipse.uml2.uml.Class backingSensor = createClass(base, BACKING_SENSOR_CLASS);
        org.eclipse.uml2.uml.Class laurin = findClassIn(base, LAURIN_CLASS_NAME);
        createProperty(laurin, BACKING_SENSOR_PROPERTY, backingSensor);
    }

    public boolean hasExtraWheel() {
        org.eclipse.uml2.uml.Class laurinClass = findLaurinClass();
        if (laurinClass == null) {
            return false;
        }

        org.eclipse.uml2.uml.Class extraWheel = findExtraWheel();
        if (extraWheel == null) {
            return false;
        }

        return laurinClass.getAttribute(BACKING_SENSOR_PROPERTY, extraWheel) != null;
    }

    public void enableParkAssist() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        assert base != null : "No base package";
        org.eclipse.uml2.uml.Class parkingAssist = createClass(base, PARKING_ASSIST_CLASS);
        org.eclipse.uml2.uml.Class laurin = findClassIn(base, LAURIN_CLASS_NAME);
        createProperty(laurin, PARKING_ASSIST_PROPERTY, parkingAssist);
    }

    public boolean hasParkAssist() {
        org.eclipse.uml2.uml.Class laurinClass = findLaurinClass();
        if (laurinClass == null) {
            return false;
        }

        org.eclipse.uml2.uml.Class parkingAssist = findParkingAssist();
        if (parkingAssist == null) {
            return false;
        }

        return laurinClass.getAttribute(PARKING_ASSIST_PROPERTY, parkingAssist) != null;
    }

    private org.eclipse.uml2.uml.Class findParkingAssist() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        assert base != null : "No base package";

        return findClassIn(base, PARKING_ASSIST_CLASS);
    }

    private static final String LAURIN_CLASS_NAME = "Laurin";
    private static final String BACKING_SENSOR_CLASS = "BackingSensor";
    private static final String BACKING_SENSOR_PROPERTY = "backingSensor";
    private static final String PARKING_ASSIST_CLASS = "ParkingAssist";
    private static final String PARKING_ASSIST_PROPERTY = "parkingAssist";
    private static final String EXTRA_WHEEL_CLASS = "ExtraWheel";

    private org.eclipse.uml2.uml.Class findExtraWheel() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        assert base != null : "No base package";

        return findClassIn(base, EXTRA_WHEEL_CLASS);
    }

    public void enableExtraWheel() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        assert base != null : "No base package";

        org.eclipse.uml2.uml.Class extraWheel = createClass(base, EXTRA_WHEEL_CLASS);
        org.eclipse.uml2.uml.Class laurin = findClassIn(base, LAURIN_CLASS_NAME);
        createProperty(laurin, EXTRA_WHEEL_PROPERTY, extraWheel);
    }
    
    private static final String EXTRA_WHEEL_PROPERTY = "extraWheel";

    private org.eclipse.uml2.uml.Class createClass(org.eclipse.uml2.uml.Package thePackage, String className) {
        org.eclipse.uml2.uml.Class theClass = factory.createClass();
        theClass.setName(className);
        thePackage.getPackagedElements().add(theClass);
        return theClass;
    }

    private void createProperty(org.eclipse.uml2.uml.Class theClass, String propertyName, org.eclipse.uml2.uml.Type theType) {
        Property theProperty = UMLFactory.eINSTANCE.createProperty();
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
        return (org.eclipse.uml2.uml.Package) laurin.getPackagedElement("Base");
    }

    public boolean hasLaurinCar() {
        return findLaurinClass() != null;
    }

    /**
     * Load and wrap the model given as parameter
     *
     * @param path the path to the model to wrap
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
     * @param model the UML2 model to wrap
     * @return the Laurin object
     */
    public static Laurin from(Model model) {
        return new Laurin(model);
    }

}

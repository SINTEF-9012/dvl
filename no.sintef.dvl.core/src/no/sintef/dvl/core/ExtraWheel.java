package no.sintef.dvl.core;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

public class ExtraWheel implements IFeatureConfig {

    private final Model model;

    public ExtraWheel(Model model) {
        assert model != null : "Invalid UML2 model ('null' found)";

        this.model = model;
    }

    @Override
    public boolean pre() {
        return findLaurinClass() != null;
    }

    private org.eclipse.uml2.uml.Class findLaurinClass() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        if (base == null) {
            return null;
        }
        Classifier laurinClass = (Classifier) base.getPackagedElement("Laurin");
        return (Class) laurinClass;
    }

    private Package findBasePackage() {
        return (org.eclipse.uml2.uml.Package) model.getPackagedElement("Base");
    }

    @Override
    public boolean post() {
        Class laurinClass = findLaurinClass();
        if (laurinClass == null) {
            return false;
        }

        EList<Element> content = laurinClass.allOwnedElements();
        for (Element anyElement : content) {
            if (anyElement instanceof Property) {
                Property eachProperty = (Property) anyElement;
                if (eachProperty.getName().equals("extraWheel")
                        && eachProperty.getType().getName().equals("ExtraWheel")) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void configure() {
        if (!pre()) {
            throw new IllegalStateException("The given model is not ready to configure the feature 'extra wheel'");
        }

        Class extraWheelClass = createExtraWheelType();
        createExtraWheelProperty(extraWheelClass);

    }

    private Class createExtraWheelType() {
        org.eclipse.uml2.uml.Package base = findBasePackage();
        assert base != null : "No package 'Base'. This shoud have been detected by the pre-condition";
        Class extraWheelClass = UMLFactory.eINSTANCE.createClass();
        extraWheelClass.setName("ExtraWheel");
        return extraWheelClass;
    }

    private void createExtraWheelProperty(Class extraWheelClass) {
        Class laurinClass = findLaurinClass();
        assert laurinClass != null : "No class 'Laurin'. This should have detected by the pre-condition";

        Property extraWheelProperty = UMLFactory.eINSTANCE.createProperty();
        extraWheelProperty.setName("extraWheel");
        extraWheelProperty.setType(extraWheelClass);
        
        laurinClass.getOwnedAttributes().add(extraWheelProperty);
    }
}

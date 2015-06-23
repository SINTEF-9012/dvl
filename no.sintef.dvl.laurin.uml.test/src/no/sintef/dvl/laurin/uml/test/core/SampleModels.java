package no.sintef.dvl.laurin.uml.test.core;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * A catalog of models, used for testing purposes
 */
public class SampleModels {

    private UMLFactory factory;

    public SampleModels() {
        factory = UMLFactory.eINSTANCE;
    }

    public Model empty() {
        return factory.createModel();
    }

    public Model emptyBasePackage() {
        Model model = factory.createModel();
        createBasePackage(model);
        return model;
    }

    private org.eclipse.uml2.uml.Package createBasePackage(Model model) {
        org.eclipse.uml2.uml.Package base = factory.createPackage();
        base.setName("Base");
        model.getPackagedElements().add(base);
        return base;
    }
    
    public Model emptyLaurinClass() {
        Model model = factory.createModel();
        org.eclipse.uml2.uml.Package base = createBasePackage(model);
        createLaurinClass(base);
        return model;
    }

    private void createLaurinClass(Package base) {
        org.eclipse.uml2.uml.Class laurin = factory.createClass();
        laurin.setName("Laurin");
        base.getPackagedElements().add(laurin);
    }

}

package no.sintef.dvl.core.test;

import no.sintef.dvl.core.ExtraWheel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class ExtraWheelTest {

    @Test
    public void preShouldDetectTheExistenceOfTheLaurinClass() {
        ExtraWheel feature = new ExtraWheel(loadModelFrom("resources/yeti.uml"));
        assertThat(feature.pre(), is(true));
    }
    
      @Test
    public void postShouldNotBeValidOnTheInitialYetiModel() {
        ExtraWheel feature = new ExtraWheel(loadModelFrom("resources/yeti.uml"));
        assertThat(feature.post(), is(false));
    }

    @Test
    public void shouldBeConfiguredProperlyIfReady() {

        ExtraWheel feature = new ExtraWheel(loadModelFrom("resources/yeti.uml"));

        assertThat(feature.pre(), is(true));

        feature.configure();

        assertThat(feature.post(), is(true));
    }

    public Model loadModelFrom(String pathToModel) {
        UMLPackage.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        reg.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());

        ResourceSet resSet = new ResourceSetImpl();
        Resource resource = resSet.getResource(URI.createURI(pathToModel), true);

        Model model = (Model) resource.getContents().get(0);
        return model;
    }

}

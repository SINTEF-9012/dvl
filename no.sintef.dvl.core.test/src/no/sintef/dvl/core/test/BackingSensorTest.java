package no.sintef.dvl.core.test;

import no.sintef.dvl.core.BackingSensor;
import no.sintef.dvl.core.Laurin;
import org.eclipse.uml2.uml.Model;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class BackingSensorTest {

    private final SampleModels models;

    public BackingSensorTest() {
        models = new SampleModels();
    }

    @Test
    public void preShouldDetectMissingBasePackage() {
        BackingSensor feature = prepareFeature(models.empty());
        assertThat(feature.pre(), is(false));
    }

    @Test
    public void preShouldDetectMissingLaurinClass() {
        BackingSensor feature = prepareFeature(models.emptyBasePackage());
        assertThat(feature.pre(), is(false));
    }

    @Test
    public void configureShouldEnablePostCondition() {
        BackingSensor feature = prepareFeature("resources/yeti.uml");
        assertThat(feature.pre(), is(true));
        feature.configure();
        assertThat(feature.post(), is(true));
    }

    @Test
    public void postShouldDetectMissingBackingSensorProperty() {
        BackingSensor feature = prepareFeature(models.emptyLaurinClass());
        assertThat(feature.pre(), is(true));
        assertThat(feature.post(), is(false));
    }

    @Test
    public void postShouldDetectMissingBackingSensorClass() {
        BackingSensor feature = prepareFeature(models.emptyLaurinClass());
        assertThat(feature.pre(), is(true));
        assertThat(feature.post(), is(false));
    }

    private BackingSensor prepareFeature(String path) {
        final Laurin car = Laurin.loadFrom(path);
        BackingSensor feature = new BackingSensor(car);
        return feature;
    }

    private BackingSensor prepareFeature(Model model) {
        final Laurin car = Laurin.from(model);
        BackingSensor feature = new BackingSensor(car);
        return feature;
    }

}

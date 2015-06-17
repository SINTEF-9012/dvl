package no.sintef.dvl.core;

public class ExtraWheel extends LaurinFeature {

    public ExtraWheel(Laurin model) {
        super(model);
    }

    @Override
    public boolean pre() {
        return model.hasLaurinCar();
    }

    @Override
    public boolean post() {
        return model.hasExtraWheel();
    }

    @Override
    public void configure() {
        if (!pre()) {
            throw new IllegalStateException("The given model is not ready to configure the feature 'extra wheel'");
        }

        model.enableExtraWheel();
    }

}

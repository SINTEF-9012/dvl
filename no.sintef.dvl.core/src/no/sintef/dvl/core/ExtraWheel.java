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
    protected void doConfiguration() {
        model.enableExtraWheel();
    }

}

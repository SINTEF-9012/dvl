package no.sintef.dvl.test.dummies;

import no.sintef.dvl.core.interfaces.common.IFeatureConfig;

public class FeatureConfig implements IFeatureConfig {

    private boolean ready;
    private boolean[] invoked;

    public FeatureConfig(boolean ready) {
        this.ready = ready;
        invoked = new boolean[]{false, false, false};
    }
    

    @Override
    public void configure() {
        invoked[CONFIGURE] = true;
    }

    @Override
    public boolean pre() {
        invoked[PRE] = true;
        return ready;
    }

    @Override
    public boolean post() {
        invoked[POST] = true;
        return true;
    }
    
    public boolean wasInvoked(int method) {
        return invoked[method];
    }

    public static final int CONFIGURE = 0;
    public static final int PRE = 1;
    public static final int POST = 2;
}

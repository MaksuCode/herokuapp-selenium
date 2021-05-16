package org.maksu;

import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

public class CustomStrategy implements ParallelExecutionConfiguration , ParallelExecutionConfigurationStrategy {

    int parallisim = Integer.parseInt(System.getProperty("parallelism"));

    public void setParallisim(int value){
        this.parallisim = value ;
    }

    @Override
    public int getParallelism() {
        return this.parallisim;
    }

    @Override
    public int getMinimumRunnable() {
        return this.parallisim;
    }

    @Override
    public int getMaxPoolSize() {
        return this.parallisim;
    }

    @Override
    public int getCorePoolSize() {
        return this.parallisim;
    }

    @Override
    public int getKeepAliveSeconds() {
        return 30;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        return this;
    }
}

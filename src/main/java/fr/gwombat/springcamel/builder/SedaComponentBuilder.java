package fr.gwombat.springcamel.builder;

import java.util.concurrent.TimeUnit;

/**
 * @author gfabbi
 **/
public final class SedaComponentBuilder extends AbstractComponentBuilder {

    SedaComponentBuilder(String routeName) {
        super(routeName);
    }

    @Override
    protected String getPrefix() {
        return "seda:";
    }

    public SedaComponentBuilder size(int size) {
        addParameter("size", size);
        return this;
    }

    public SedaComponentBuilder concurrentConsumers(int concurrentConsumers) {
        addParameter("concurrentConsumers", concurrentConsumers);
        return this;
    }

    /**
     * @param timeout
     *         in milliseconds
     * @return the builder
     */
    public SedaComponentBuilder timeout(int timeout) {
        addParameter("timeout", timeout);
        return this;
    }

    public SedaComponentBuilder timeout(int timeout, TimeUnit timeUnit) {
        addParameter("timeout", timeUnit.toMillis(timeout));
        return this;
    }

    public SedaComponentBuilder multipleConsumers(boolean multipleConsumers) {
        addParameter("multipleConsumers", multipleConsumers);
        return this;
    }

    public SedaComponentBuilder limitConcurrentConsumers(boolean limitConcurrentConsumers) {
        addParameter("limitConcurrentConsumers", limitConcurrentConsumers);
        return this;
    }

    public SedaComponentBuilder blockWhenFull(boolean blockWhenFull) {
        addParameter("blockWhenFull", blockWhenFull);
        return this;
    }

    public SedaComponentBuilder queueSize(int queueSize) {
        addParameter("queueSize", queueSize);
        return this;
    }

    public SedaComponentBuilder pollTimeout(int pollTimeout) {
        addParameter("pollTimeout", pollTimeout);
        return this;
    }

    public SedaComponentBuilder purgeWhenStopping(boolean purgeWhenStopping) {
        addParameter("purgeWhenStopping", purgeWhenStopping);
        return this;
    }

    public SedaComponentBuilder queue(String queue) {
        addParameter("queue", queue);
        return this;
    }

    public SedaComponentBuilder queueFactory(String queueFactory) {
        addParameter("queueFactory", queueFactory);
        return this;
    }

    public SedaComponentBuilder failIfNoConsumers(boolean failIfNoConsumers) {
        addParameter("failIfNoConsumers", failIfNoConsumers);
        return this;
    }

    public SedaComponentBuilder discardIfNoConsumers(boolean discardIfNoConsumers) {
        addParameter("discardIfNoConsumers", discardIfNoConsumers);
        return this;
    }
}

package fr.gwombat.springcamel.builder;

/**
 * @author gfabbi
 **/
public final class BeanComponentBuilder extends AbstractComponentBuilder {

    BeanComponentBuilder(String routeName) {
        super(routeName);
    }

    public BeanComponentBuilder method(String method) {
        addParameter("method", method);
        return this;
    }

    public BeanComponentBuilder cache(boolean cache) {
        addParameter("cache", cache);
        return this;
    }

    public BeanComponentBuilder multiParameterArray(boolean multiParameterArray) {
        addParameter("multiParameterArray", multiParameterArray);
        return this;
    }

    public BeanComponentBuilder property(String propName, Object val) {
        addParameter("bean." + propName, val);
        return this;
    }

    @Override
    protected String getPrefix() {
        return "bean:";
    }
}

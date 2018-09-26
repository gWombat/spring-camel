package fr.gwombat.springcamel.builder;

/**
 * @author gfabbi
 **/
public final class CamelComponentBuilder {

    private CamelComponentBuilder() {

    }

    public static SedaComponentBuilder seda(String routeName) {
        return new SedaComponentBuilder(routeName);
    }

    public static BeanComponentBuilder bean(String routeName) {
        return new BeanComponentBuilder(routeName);
    }
}

package fr.gwombat.springcamel.support;

/**
 * Created by guillaume.
 *
 * @since 23/09/2018
 */
public final class Constants {

    public static final String ROUTE_HELLO_WORLD = seda("hello-world-route");

    private Constants() {

    }

    private static String seda(String routeName) {
        return "seda:" + routeName;
    }

}

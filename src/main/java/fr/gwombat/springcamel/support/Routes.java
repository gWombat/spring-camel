package fr.gwombat.springcamel.support;

import fr.gwombat.springcamel.builder.CamelComponentBuilder;

/**
 * Created by guillaume.
 *
 * @since 23/09/2018
 */
public final class Routes {

    public static final String ROUTE_HELLO_WORLD = CamelComponentBuilder.seda("hello-world-route").concurrentConsumers(3).build();

    private Routes() {

    }
}

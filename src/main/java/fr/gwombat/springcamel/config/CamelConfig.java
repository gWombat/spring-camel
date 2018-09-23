package fr.gwombat.springcamel.config;

import fr.gwombat.springcamel.services.HelloWorldService;
import fr.gwombat.springcamel.support.Constants;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by guillaume.
 *
 * @since 23/09/2018
 */
@Configuration
public class CamelConfig extends CamelConfiguration {

    private HelloWorldService helloWorldService;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setConfigClass(CamelConfig.class);
        main.run();
    }

    @Bean
    public RouteBuilder routeBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(Constants.ROUTE_HELLO_WORLD).bean(helloWorldService, "getHelloWorld");
            }
        };
    }

    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}

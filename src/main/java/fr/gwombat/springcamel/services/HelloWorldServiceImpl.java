package fr.gwombat.springcamel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by guillaume.
 *
 * @since 23/09/2018
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Override
    public String getHelloWorld(String value) {
        LOGGER.info("Call service with val {}", value);
        return "Hello " + value + " World from Camel";
    }
}

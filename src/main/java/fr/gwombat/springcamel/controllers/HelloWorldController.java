package fr.gwombat.springcamel.controllers;

import fr.gwombat.springcamel.support.Constants;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by guillaume.
 *
 * @since 23/09/2018
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    private ProducerTemplate producerTemplate;

    @GetMapping("/{val}")
    public String helloWorld(@PathVariable String val) {
        LOGGER.info("Start controller. Calling camel service...");
        CompletableFuture<String> result = producerTemplate.asyncRequestBody(Constants.ROUTE_HELLO_WORLD, val, String.class);
        LOGGER.info("Service called... Waiting for result");
        try {
            return result.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("", e);
            return null;
        }
    }

    @Autowired
    public void setProducerTemplate(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}

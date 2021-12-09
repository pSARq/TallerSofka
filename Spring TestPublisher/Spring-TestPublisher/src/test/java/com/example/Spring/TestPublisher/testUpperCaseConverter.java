package com.example.Spring.TestPublisher;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class testUpperCaseConverter {

    final TestPublisher<String> testPublisher = TestPublisher.create();

    @Test
    void testUpperCase(){
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(testPublisher.flux());
        StepVerifier.create(upperCaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("Datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }
}

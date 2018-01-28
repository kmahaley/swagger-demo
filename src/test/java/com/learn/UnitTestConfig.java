package com.learn;

import com.learn.service.CalculatorService;
import com.learn.service.impl.CalculatorServiceStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Configuration is defined for profile named "stub-test"
 * "CalculatorServiceStub" is used in place of {@link CalculatorService} in HelloController
 *
 * @author km185223
 */
@Profile("stub-test")
@Configuration
public class UnitTestConfig {

    @Bean
    @Primary
    public CalculatorService calculatorServiceBean() {
        return new CalculatorServiceStub();
    }
}

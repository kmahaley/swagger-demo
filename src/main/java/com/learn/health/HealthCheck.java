package com.learn.health;/*
 *-----------------------------------------------------------------------------
 * Copyright 2017 NCR Corporation
 *-----------------------------------------------------------------------------
 */

import com.learn.model.Person;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * health check endpoint for the service
 *
 * @author km185223
 */
@Component
public class HealthCheck implements HealthIndicator {
    /**
     * Return an indication of health.
     *
     * @return the health for
     */
    @Override
    public Health health() {
        return Health.outOfService().withDetail("apple", new Person()).build();

    }
}

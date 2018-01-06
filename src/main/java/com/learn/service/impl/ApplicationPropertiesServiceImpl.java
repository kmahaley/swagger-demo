package com.learn.service.impl;/*
 *-----------------------------------------------------------------------------
 * Copyright 2017 NCR Corporation
 *-----------------------------------------------------------------------------
 */

import com.learn.properties.ApplicationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Application properties service which demos how to inject configuration properties and use it
 *
 * @author km185223
 */
@Service
@EnableConfigurationProperties(ApplicationProperties.class)
public class ApplicationPropertiesServiceImpl {

    private final ApplicationProperties applicationProperties;

    public ApplicationPropertiesServiceImpl(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public ApiInfo getMetaData() {
        System.out.println(applicationProperties);

        ApiInfo apiInfo = new ApiInfo(
                applicationProperties.getName(),
                applicationProperties.getDescription(),
                applicationProperties.getVersion(),
                applicationProperties.getTermsOfService(),
                new Contact(applicationProperties.getContactName(),
                        applicationProperties.getContactUrl(),
                        applicationProperties.getContactEmail()),
                applicationProperties.getLicenseName(),
                applicationProperties.getLicenseUrl());
        return apiInfo;
    }
}

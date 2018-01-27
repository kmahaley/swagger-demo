package com.learn.service.impl;/*
 *-----------------------------------------------------------------------------
 * Copyright 2017 NCR Corporation
 *-----------------------------------------------------------------------------
 */

import com.learn.exception.CustomTestException;
import com.learn.properties.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Application properties service which demos how to inject configuration properties and use it
 *
 * @author km185223
 */
@Slf4j
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
                new Contact(
                        applicationProperties.getContactName(),
                        applicationProperties.getContactUrl(),
                        applicationProperties.getContactEmail()),
                applicationProperties.getLicenseName(),
                applicationProperties.getLicenseUrl());
        log.info(String.format("Properties of the application are %s", apiInfo));
        return apiInfo;
    }

    public String getExceptionMethod(String str) throws CustomTestException {
        final String methodName = "1) ApplicationPropertiesServiceImpl.getExceptionMethod";
        if (StringUtils.equals(str, "exception")) {
            log.info(String.format("Method name : %s", methodName));
            throw new CustomTestException(String.format(
                    "Custom resource exception for : %s",
                    methodName + "\t" + str + "\n"));
        }
        return str;
    }
}

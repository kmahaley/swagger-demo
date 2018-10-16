package com.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Kartik
 */
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return (String... args) -> {
//
//            log.info("Let's inspect the beans provided by Spring Boot:\n");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays
//                    .asList(beanNames)
//                    .stream()
//                    .sorted()
//                    .forEach((bean) -> log.info(bean));
//        };
//    }
}

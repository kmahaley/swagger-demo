package com.learn.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private PersonId personId;

    private String name;

    private Address address;

    private ManifestData manifest;

    private int age;

    private Gender gender;
}

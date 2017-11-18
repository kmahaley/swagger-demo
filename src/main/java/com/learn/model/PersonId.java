package com.learn.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author kartik
 */
@Data
@AllArgsConstructor
public class PersonId implements Serializable {
    private String id;
}

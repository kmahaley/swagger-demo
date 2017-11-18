package com.learn.model;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kartik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageData implements Serializable {
    private String name;

    private double weight;

    private double height;

    private boolean fragile;
}

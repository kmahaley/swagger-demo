package com.learn.model;

/**
 * @author kartik
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ManifestData implements Serializable {
    private String currencyCode;

    private String totalValue;

    private List<PackageData> packages = new ArrayList<>();
}

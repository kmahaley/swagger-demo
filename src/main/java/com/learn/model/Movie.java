package com.learn.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kartik
 */
@Data
@NoArgsConstructor
public class Movie<U, V, W, X> {
    private  U name;
    private V collection;
    private List<W> nameOfCasts;
    private X isAdult;
}

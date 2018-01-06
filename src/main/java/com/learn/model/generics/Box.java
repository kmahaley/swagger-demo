package com.learn.model.generics;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kartik
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Box<T> {

    private T name;

    private List<T> contents;
}

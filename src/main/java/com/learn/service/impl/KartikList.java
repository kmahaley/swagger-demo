package com.learn.service.impl;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

/**
 * TODO : add description
 */
public class KartikList extends ArrayList {

    int[] arraystore= new int[10];
    int index;

    public KartikList(int initialCapacity) {
        super(initialCapacity);
    }

    public int apple(){
        return this.size();
    }

    public void addme(int i){
        this.add(i);
    }

    public void printMe(){
        this.forEach(x -> System.out.println(x));
    }
}

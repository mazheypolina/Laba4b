package com.c;

import java.util.Random;

public class BusinessClass extends Plane{
    Random rnd = new Random();

    BusinessClass(){
        super();
    }

    void SetCharacteristics(){
        passengers = rnd.nextInt(100 - 50  + 1) + 50;
        weight = passengers * 0.3;
        distance = rnd.nextInt(6000 - 3500 + 1) + 3500;
        fuelConsumption = distance / weight / 2;
    }
}

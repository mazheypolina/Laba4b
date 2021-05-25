package com.c;

import java.util.Random;

public class EconomyClass extends Plane{
    Random rnd = new Random();

    EconomyClass(){
        super();
    }

    void SetCharacteristics(){
        passengers = rnd.nextInt(200 - 100  + 1) + 100;
        weight = passengers * 0.23;
        distance = rnd.nextInt(4000 - 2500 + 1) + 2500;
        fuelConsumption = distance / weight / 2;
    }
}

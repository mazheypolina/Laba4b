package com.c;

import java.util.Random;

public class FirstClass extends Plane {
    Random rnd = new Random();

    FirstClass(){
        super();
    }

    void SetCharacteristics(){
        passengers = rnd.nextInt(150 - 90  + 1) + 90;
        weight = passengers * 0.23;
        distance = rnd.nextInt(5000 - 3000 + 1) + 3000;
        fuelConsumption = distance / weight / 2;
    }
}

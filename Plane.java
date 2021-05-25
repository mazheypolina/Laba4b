package com.c;

public class Plane {
    int id, passengers, distance;
    double weight, fuelConsumption;

    Plane(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getId() {
        return id;
    }

    public int getPassengers() {
        return passengers;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", passengers=" + passengers +
                ", weight=" + weight +
                ", distance=" + distance +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }


}


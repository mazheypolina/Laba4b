package com.c;

public class Airline {
    int numFirst, numBusiness, numEconomy;

    FirstClass[] firstClasses;
    BusinessClass[] businessClasses;
    EconomyClass[] economyClasses;

    Airline(){
        super();
    }

    public int getNumFirst() {
        return numFirst;
    }

    public void setNumFirst(int numFirst) {
        this.numFirst = numFirst;
    }

    public int getNumBusiness() {
        return numBusiness;
    }

    public void setNumBusiness(int numBusiness) {
        this.numBusiness = numBusiness;
    }

    public int getNumEconomy() {
        return numEconomy;
    }

    public void setNumEconomy(int numEconomy) {
        this.numEconomy = numEconomy;
    }

    void CreateAirline(){
        firstClasses = new FirstClass[numFirst];
        businessClasses = new BusinessClass[numBusiness];
        economyClasses = new EconomyClass[numEconomy];
        for (int i = 0; i < numFirst; i++) {
            firstClasses[i] = new FirstClass();
            firstClasses[i].SetCharacteristics();
            firstClasses[i].setId(i);
        }
        for (int i = 0; i < numEconomy; i++) {
            economyClasses[i] = new EconomyClass();
            economyClasses[i].SetCharacteristics();
            economyClasses[i].setId(i);
        }
        for (int i = 0; i < numBusiness; i++) {
            businessClasses[i] = new BusinessClass();
            businessClasses[i].SetCharacteristics();
            businessClasses[i].setId(i);
        }
    }
}

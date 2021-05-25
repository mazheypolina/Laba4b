package com.c;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class Main {
    static String inPath = "./res/in.txt";
    static File inFile = new File(inPath);
    static Scanner in, menu;
    static Airline airline = new Airline();
    static int maxPassengers = 0;
    static double maxWeight = 0.0;

    static void outAirline(){
        for(int i = 0; i < airline.numEconomy; i++){
            System.out.println(airline.economyClasses[i].toString());
        }
        System.out.println();
        for(int i = 0; i < airline.numFirst; i++){
            System.out.println(airline.firstClasses[i].toString());
        }
        System.out.println();
        for(int i = 0; i < airline.numBusiness; i++){
            System.out.println(airline.businessClasses[i].toString());
        }
    }

    static void countMax(){
        for(int i = 0; i < airline.numEconomy; i++){
            maxPassengers += airline.economyClasses[i].getPassengers();
            maxWeight += airline.economyClasses[i].getWeight();
        }
        for(int i = 0; i < airline.numFirst; i++){
            maxPassengers += airline.firstClasses[i].getPassengers();
            maxWeight += airline.firstClasses[i].getWeight();
        }
        for(int i = 0; i < airline.numBusiness; i++){
            maxPassengers += airline.businessClasses[i].getPassengers();
            maxWeight += airline.businessClasses[i].getWeight();
        }
        System.out.println("Максимальное число пассажиров: " + maxPassengers);
        System.out.println("Максимальная грузоподъёмность: " + maxWeight);
    }

    static void planeSort(){
        for(int i = 0; i < airline.numEconomy - 1; i++){
            for (int j = 0; j < airline.numEconomy - i - 1; j++){
                if(airline.economyClasses[j].getFuelConsumption() > airline.economyClasses[j + 1].getFuelConsumption()){
                    EconomyClass temp;
                    temp = airline.economyClasses[j];
                    airline.economyClasses[j] = airline.economyClasses[j + 1];
                    airline.economyClasses[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < airline.numFirst; i++){
            for (int j = 0; j < airline.numFirst - i - 1; j++){
                if(airline.firstClasses[j].getFuelConsumption() > airline.firstClasses[j + 1].getFuelConsumption()){
                    FirstClass temp;
                    temp = airline.firstClasses[j];
                    airline.firstClasses[j] = airline.firstClasses[j + 1];
                    airline.firstClasses[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < airline.numBusiness; i++){
            for (int j = 0; j < airline.numBusiness - i - 1; j++){
                if(airline.businessClasses[j].getFuelConsumption() > airline.businessClasses[j + 1].getFuelConsumption()){
                    BusinessClass temp;
                    temp = airline.businessClasses[j];
                    airline.businessClasses[j] = airline.businessClasses[j + 1];
                    airline.businessClasses[j + 1] = temp;
                }
            }
        }
        outAirline();
    }

    static void findPlanes(){
        int idCheap = -1, idComfort = -1, idBusiness = -1;
        double minFuel, maxFuel;
        System.out.println("Введите диапазон скорости(минимальная и максимальная): ");
        minFuel = menu.nextDouble();
        maxFuel = menu.nextDouble();
        for(int i = 0; i < airline.numEconomy; i++){
            if(airline.economyClasses[i].getFuelConsumption() > minFuel && airline.firstClasses[i].getFuelConsumption() < maxFuel)
                idCheap = i;
            if(idCheap != -1)
                break;
        }
        for(int i = 0; i < airline.numFirst; i++){
            if(airline.firstClasses[i].getFuelConsumption() > minFuel && airline.firstClasses[i].getFuelConsumption() < maxFuel)
                idComfort = i;
            if(idComfort != -1)
                break;
        }
        for(int i = 0; i < airline.numBusiness; i++){
            if(airline.businessClasses[i].getFuelConsumption() > minFuel && airline.businessClasses[i].getFuelConsumption() < maxFuel)
                idBusiness = i;
            if(idBusiness != -1)
                break;
        }
        if(idCheap != -1){
            System.out.println("Самолёты эконом класса с потреблением топлива от " + minFuel + " до " + maxFuel);
            System.out.println(airline.economyClasses[idCheap].toString() + "\n");
        }
        else {
            System.out.println("Самолётов эконом класса с потреблением толпива от " + minFuel + " до " + maxFuel + " нет\n");
        }
        if(idComfort != -1){
            System.out.println("Самолёты первого класса с потреблением топлива от " + minFuel + " до " + maxFuel);
            System.out.println(airline.firstClasses[idComfort].toString() + "\n");
        }
        else {
            System.out.println("Самолётов первого класса с потреблением толпива от " + minFuel + " до " + maxFuel + " нет\n");
        }
        if(idBusiness != -1){
            System.out.println("Самолёты бизнес класса с потреблением топлива от " + minFuel + " до " + maxFuel);
            System.out.println(airline.businessClasses[idBusiness].toString() + "\n");
        }
        else {
            System.out.println("Самолётов бизнес класса с потреблением толпива от " + minFuel + " до " + maxFuel + " нет\n");
        }
    }

    public static void main(String[] args) {
        int num;

        menu = new Scanner(System.in);
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл для чтения не найден!");
        }
        try {
            num = in.nextInt();
            if(num < 1)
                throw new NotPositiveNum("Размерность массива дожна быть не отрицательной");
            airline.setNumEconomy(num);
        } catch (InputMismatchException e){
            System.out.println("Тип вводимого числа должен быть INT");
        } catch (NoSuchElementException e){
            System.out.println("Отсутствует значение в файле");
        } catch (NotPositiveNum e){
            System.out.println(e.message);
        }
        try {
            num = in.nextInt();
            if(num < 1)
                throw new NotPositiveNum("Размерность массива дожна быть не отрицательной");
            airline.setNumFirst(num);
        } catch (InputMismatchException e){
            System.out.println("Тип вводимого числа должен быть INT");
        } catch (NoSuchElementException e){
            System.out.println("Отсутствует значение в файле");
        } catch (NotPositiveNum e){
            System.out.println(e.message);
        }
        try {
            num = in.nextInt();
            if(num < 1)
                throw new NotPositiveNum("Размерность массива дожна быть не отрицательной");
            airline.setNumBusiness(num);
        } catch (InputMismatchException e){
            System.out.println("Тип вводимого числа должен быть INT");
        } catch (NoSuchElementException e){
            System.out.println("Отсутствует значение в файле");
        } catch (NotPositiveNum e){
            System.out.println(e.message);
        }
        airline.CreateAirline();

        boolean flag = true;
        int choice;
        while(flag){
            System.out.println("""
                    0.Выход
                    1.Вывод самолётов
                    2.Вычисление вместимости и грузоподъёмности
                    3.Сортировка по дальности полёта
                    4.Поиск по диапозону потребления топлива
                    """);
            choice = menu.nextInt();
            switch (choice) {
                case 0 -> flag = false;
                case 1 -> outAirline();
                case 2 -> countMax();
                case 3 -> planeSort();
                case 4 -> findPlanes();
            }
        }
    }
}

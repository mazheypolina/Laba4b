package com.c;

public class NotPositiveNum extends Exception{
    String message;

    NotPositiveNum(String str){
        message = str;
    }

}

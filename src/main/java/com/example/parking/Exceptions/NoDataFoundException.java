package com.example.parking.Exceptions;

public class NoDataFoundException  extends  RuntimeException{
    public NoDataFoundException(String message) {
        super(message);
    }
}

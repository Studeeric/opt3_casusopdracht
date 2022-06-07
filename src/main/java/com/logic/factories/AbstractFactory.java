package com.logic.factories;

public interface AbstractFactory<T>{
    T create(String type);
}

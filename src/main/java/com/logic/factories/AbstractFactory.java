package com.logic.factories;

import java.io.IOException;

public interface AbstractFactory<T>{
    T create(String type) throws IOException;
}

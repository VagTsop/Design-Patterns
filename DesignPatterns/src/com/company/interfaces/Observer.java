package com.company.interfaces;


public interface Observer<T> {
    void update(T subject);
}
package com.company.models;

import com.company.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String title;
    private boolean completed;
    private List<Observer> observers = new ArrayList<>();


    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
        notifyObservers();
    }


    public boolean isCompleted() {
        return completed;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "[" + (completed ? "X" : " ") + "] " + title;
    }
}
// Task.java
package com.company.models;

import com.company.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String title;
    private boolean completed;
    private List<Observer<Task>> observers = new ArrayList<>();
    private String type;

    public Task(String title, String type) {
        this.title = title;
        this.type = type;
        this.completed = false;
    }

    public String getType() {
        return type;
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

    public void addObserver(Observer<Task> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer<Task> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "[" + (completed ? "X" : " ") + "] " + title;
    }
}
package com.company.interfaces;

import com.company.models.Task;

public interface Observer {
    void update(Task task);
}
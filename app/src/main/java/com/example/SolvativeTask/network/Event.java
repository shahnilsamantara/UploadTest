package com.example.SolvativeTask.network;

import com.example.SolvativeTask.model.Response;

public interface Event {
    void success(Response object);
    void fail();
}

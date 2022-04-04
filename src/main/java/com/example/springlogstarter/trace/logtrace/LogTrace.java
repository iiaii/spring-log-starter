package com.example.springlogstarter.trace.logtrace;

import com.example.springlogstarter.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}

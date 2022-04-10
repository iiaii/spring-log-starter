package com.example.springlogstarter.trace.callback;

import com.example.springlogstarter.trace.TraceStatus;
import com.example.springlogstarter.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(final LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callBack) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            // 로직 호출
            T result = callBack.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}

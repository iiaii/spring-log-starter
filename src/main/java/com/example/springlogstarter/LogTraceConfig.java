package com.example.springlogstarter;

import com.example.springlogstarter.trace.callback.TraceTemplate;
import com.example.springlogstarter.trace.logtrace.LogTrace;
import com.example.springlogstarter.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

    @Bean
    public TraceTemplate traceTemplate(LogTrace trace) {
        return new TraceTemplate(trace);
    }
}

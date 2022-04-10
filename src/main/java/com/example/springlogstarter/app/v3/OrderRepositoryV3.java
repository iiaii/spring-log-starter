package com.example.springlogstarter.app.v3;

import com.example.springlogstarter.trace.TraceId;
import com.example.springlogstarter.trace.TraceStatus;
import com.example.springlogstarter.trace.hellotrace.HelloTraceV2;
import com.example.springlogstarter.trace.logtrace.LogTrace;
import com.example.springlogstarter.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            // 저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

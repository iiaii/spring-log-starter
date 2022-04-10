package com.example.springlogstarter.app.v5;

import com.example.springlogstarter.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public void save(String itemId) {
        traceTemplate.execute("OrderRepository.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

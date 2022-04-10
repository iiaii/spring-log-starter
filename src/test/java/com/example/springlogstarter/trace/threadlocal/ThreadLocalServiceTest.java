package com.example.springlogstarter.trace.threadlocal;

import com.example.springlogstarter.trace.threadlocal.code.FieldService;
import com.example.springlogstarter.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    @DisplayName("field")
    public void field() {
        log.info("main Start");
        Runnable userA = () -> threadLocalService.logic("user A");
        Runnable userB = () -> threadLocalService.logic("user B");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);
        threadB.start();

        sleep(3000);
        log.info("main exit");
    }

    private void sleep(final int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
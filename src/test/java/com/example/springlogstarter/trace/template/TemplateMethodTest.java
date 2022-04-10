package com.example.springlogstarter.trace.template;

import com.example.springlogstarter.trace.template.code.AbstractTemplate;
import com.example.springlogstarter.trace.template.code.SubLogicClass1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    @DisplayName("templateMethodV0")
    public void tempalteMethodV0() {
        logic1();
        logic2();
    }

    @Test
    @DisplayName("템플릿 메서드 패턴 적용")
    public void 템플릿메서드패턴적용() {
        AbstractTemplate template1 = new SubLogicClass1();
        template1.execute();
        AbstractTemplate template2 = new SubLogicClass1();
        template2.execute();
    }

    @Test
    @DisplayName("templateMethodV2")
    public void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };
        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };
        template1.execute();
        template2.execute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직 1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직 2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

}

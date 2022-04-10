package com.example.springlogstarter.trace.strategy;

import com.example.springlogstarter.trace.strategy.code.strategy.ContextV2;
import com.example.springlogstarter.trace.strategy.code.strategy.StrategyLogic1;
import com.example.springlogstarter.trace.strategy.code.strategy.StrategyLogic2;
import com.example.springlogstarter.trace.strategy.code.template.Callback;
import com.example.springlogstarter.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    @DisplayName("callbackV1")
    public void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직 1 실행"));
        template.execute(() -> log.info("비즈니스 로직 2 실행"));
    }

}

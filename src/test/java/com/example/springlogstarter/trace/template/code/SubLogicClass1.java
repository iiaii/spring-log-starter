package com.example.springlogstarter.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubLogicClass1 extends AbstractTemplate {

    @Override
    protected void call() {
        log.info("비즈니스 로직 1 실행");
    }

}

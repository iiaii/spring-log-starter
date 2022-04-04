package com.example.springlogstarter.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {

    private static final int UUID_SIZE = 8;
    private static final int FIRST_LEVEL = 0;

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(final String id, final int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID()
                .toString()
                .substring(0, UUID_SIZE);
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level + 1);
    }

    public boolean isFirstLevel() {
        return level == FIRST_LEVEL;
    }

}

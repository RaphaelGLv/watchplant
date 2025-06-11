package com.watchplant.app.utils;

import com.watchplant.app.enums.FrequencyEnum;

public class PrunningCount {
    private final Integer amount;
    private final FrequencyEnum frequency;

    public PrunningCount(Integer amount, FrequencyEnum frequency) {
        this.amount = amount;
        this.frequency = frequency;
    }

    public Integer getAmount() {
        return amount;
    }

    public FrequencyEnum getFrequency() {
        return frequency;
    }
}

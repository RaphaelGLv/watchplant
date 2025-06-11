package com.watchplant.app.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchplant.app.enums.IntervalEnum;

public record PruningCount(
        @JsonProperty("amount")
        Integer amount,
        @JsonProperty("interval")
        IntervalEnum interval
) {
}

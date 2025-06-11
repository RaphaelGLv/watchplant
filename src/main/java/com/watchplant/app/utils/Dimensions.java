package com.watchplant.app.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class Dimensions {
    @JsonProperty("type")
    private final String type;
    @JsonProperty("min_value")
    private final Integer minValue;
    @JsonProperty("max_value")
    private final Double maxValue;
    @JsonProperty("unit")
    private final String unit;

    /**
     * @param type TODO: Create enum to describe type
     * @param unit TODO: Create enum to describe units
     */
    public Dimensions(
            @JsonProperty("type")
            String type,
            @JsonProperty("min_value")
            Integer minValue,
            @JsonProperty("max_value")
            Double maxValue,
            @JsonProperty("unit")
            String unit
    ) {
        this.type = type;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
    }

    @JsonProperty("type")
    public String type() {
        return type;
    }

    @JsonProperty("min_value")
    public Integer minValue() {
        return minValue;
    }

    @JsonProperty("max_value")
    public Double maxValue() {
        return maxValue;
    }

    @JsonProperty("unit")
    public String unit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Dimensions) obj;
        return Objects.equals(this.type, that.type) &&
                Objects.equals(this.minValue, that.minValue) &&
                Objects.equals(this.maxValue, that.maxValue) &&
                Objects.equals(this.unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, minValue, maxValue, unit);
    }

    @Override
    public String toString() {
        return "Dimensions[" +
                "type=" + type + ", " +
                "minValue=" + minValue + ", " +
                "maxValue=" + maxValue + ", " +
                "unit=" + unit + ']';
    }

}

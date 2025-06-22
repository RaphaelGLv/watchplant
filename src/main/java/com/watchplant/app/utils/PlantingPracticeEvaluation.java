package com.watchplant.app.utils;

import java.util.List;

public record PlantingPracticeEvaluation<T>(
        boolean isCorrect,
        List<T> idealValueList
) {
}

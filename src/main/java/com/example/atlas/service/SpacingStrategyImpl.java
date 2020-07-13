package com.example.atlas.service;

import com.example.atlas.model.PracticeItem;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SpacingStrategyImpl implements SpacingStrategy {
    private final int memoryStrengthLimit = 10;

    @Override
    public void rescheduleCorrectlyAnswered(PracticeItem item) {
        if (item.getMemoryStrength() < memoryStrengthLimit) {
            item.setMemoryStrength(item.getMemoryStrength() + 1);
        }
        int nextReviewInDays = item.getMemoryStrength();
        item.setNextReview(currentDate().plusDays(nextReviewInDays));
    }

    private LocalDate currentDate() {
        return LocalDate.now();
    }

}

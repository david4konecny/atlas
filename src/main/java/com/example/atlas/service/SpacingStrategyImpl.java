package com.example.atlas.service;

import com.example.atlas.model.PracticeItem;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SpacingStrategyImpl implements SpacingStrategy {
    private final int[] scheduleSequence = new int[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };

    @Override
    public void rescheduleCorrectlyAnswered(PracticeItem item) {
        if (item.getMemoryStrength() < scheduleSequence.length) {
            item.setMemoryStrength(item.getMemoryStrength() + 1);
        }
        int nextReviewInDays = scheduleSequence[item.getMemoryStrength() - 1];
        item.setNextReview(currentDate().plusDays(nextReviewInDays));
    }

    private LocalDate currentDate() {
        return LocalDate.now();
    }

}

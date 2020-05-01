package com.example.atlas.service;

import com.example.atlas.model.PracticeItem;

public interface SpacingStrategy {

    void rescheduleCorrectlyAnswered(PracticeItem item);

}

package com.example.atlas.service;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    private @Autowired PracticeRepository practiceRepository;

    public void saveAll(List<PracticeItem> items) {
        practiceRepository.saveAll(items);
    }

}

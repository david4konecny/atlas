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

    public List<PracticeItem> getPracticeByRegion(String region) {
        return practiceRepository.getPracticeByRegion(region);
    }

    public void increaseMemoryStrength(Long id) {
        PracticeItem item = practiceRepository.getOne(id);
        item.setMemoryStrength(item.getMemoryStrength() + 1);
        practiceRepository.save(item);
    }

    public void resetMemoryStrength(Long id) {
        PracticeItem item = practiceRepository.getOne(id);
        item.setMemoryStrength(0);
        practiceRepository.save(item);
    }

}

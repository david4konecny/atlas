package com.example.atlas.service;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.model.Region;
import com.example.atlas.repository.MapsData;
import com.example.atlas.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class PracticeService {
    private @Autowired PracticeRepository practiceRepository;

    public void saveAll(List<PracticeItem> items) {
        practiceRepository.saveAll(items);
    }

    public List<PracticeItem> getPracticeByRegion(String username, String region) {
        return practiceRepository.findByUsernameAndRegion(username, region);
    }

    public List<PracticeItem> getItemsByRegionSortedByNextReview(String region, String username) {
        return practiceRepository.findByUsernameAndRegionOrderByNextReview(username, region);
    }

    public void increaseMemoryStrength(Long id) {
        PracticeItem item = practiceRepository.getOne(id);
        int newMemoryStrength = item.getMemoryStrength() + 1;
        item.setMemoryStrength(newMemoryStrength);
        item.setNextReview(LocalDate.now().plusDays(newMemoryStrength));
        practiceRepository.save(item);
    }

    public void resetMemoryStrength(Long id) {
        PracticeItem item = practiceRepository.getOne(id);
        item.setMemoryStrength(0);
        practiceRepository.save(item);
    }

    public void addPracticeItem(String username, String country, String region) {
        PracticeItem item = new PracticeItem(username, country, region, LocalDate.now().plusDays(1L));
        practiceRepository.save(item);
    }

    public Region getRegionByName(String region) {
        return MapsData.REGIONS.get(region);
    }

    public Collection<Region> getAllRegions() {
        return MapsData.REGIONS.values();
    }

}

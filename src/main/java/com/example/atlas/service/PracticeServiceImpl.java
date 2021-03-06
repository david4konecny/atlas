package com.example.atlas.service;

import com.example.atlas.exception.RegionNotFoundException;
import com.example.atlas.model.PracticeItem;
import com.example.atlas.model.Region;
import com.example.atlas.repository.MapsData;
import com.example.atlas.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PracticeServiceImpl implements PracticeService {
    private @Autowired PracticeRepository practiceRepository;
    private @Autowired SpacingStrategy spacingStrategy;

    public void saveAll(List<PracticeItem> items) {
        practiceRepository.saveAll(items);
    }

    public List<PracticeItem> getPracticeByRegion(String username, String region) {
        if (!MapsData.getRegionIds().contains(region))
            throw new RegionNotFoundException();
        return practiceRepository.findByUsernameAndRegion(username, region);
    }

    public List<PracticeItem> getItemsByRegionSortedByNextReview(String region, String username) {
        if (!MapsData.getRegionIds().contains(region))
            throw new RegionNotFoundException();
        return practiceRepository.findByUsernameAndRegionOrderByNextReview(username, region);
    }

    public void increaseMemoryStrength(Long itemId, String username) {
        PracticeItem item = practiceRepository.getOne(itemId);
        if (item.getUsername().equals(username)) {
            spacingStrategy.rescheduleCorrectlyAnswered(item);
            practiceRepository.save(item);
        }
    }

    public void resetMemoryStrength(Long itemId, String username) {
        PracticeItem item = practiceRepository.getOne(itemId);
        if (item.getUsername().equals(username)) {
            item.setMemoryStrength(0);
            practiceRepository.save(item);
        }
    }

    public void addPracticeItem(String username, String country, String region) {
        if (MapsData.isCountryInRegion(country, region)) {
            PracticeItem item = new PracticeItem(username, country, region);
            spacingStrategy.rescheduleCorrectlyAnswered(item);
            practiceRepository.save(item);
        }
    }

    public Region getRegionById(String regionId) {
        if (!MapsData.getRegionIds().contains(regionId))
            throw new RegionNotFoundException();
        return MapsData.getRegion(regionId);
    }

    public Collection<Region> getAllRegions() {
        return MapsData.getRegions();
    }

    public String getRegionName(String regionId) {
        return MapsData.getRegion(regionId).getName();
    }

    public Map<String, Long> getNumOfItemsForPracticeByRegion(String username) {
        Map<String, Long> res = new HashMap<>();
        List<PracticeItem> practiceItems = practiceRepository.findByUsername(username);
        Map<String, Integer> all = MapsData.getNumberOfCountriesPerRegion();
        Map<String, Long> due = getNumOfDuePerRegion(practiceItems);
        Map<String, Long> practiced = getNumOfPracticedPerRegion(practiceItems);
        all.forEach((name, total) -> {
                    res.put(name, total - practiced.getOrDefault(name, 0L) + due.getOrDefault(name, 0L));
                }
        );
        return res;
    }

    private Map<String, Long> getNumOfDuePerRegion(List<PracticeItem> items) {
        return items.stream()
                .filter(i -> !i.getNextReview().isAfter(LocalDate.now()))
                .collect(Collectors.groupingBy(PracticeItem::getRegion, Collectors.counting()));
    }

    private Map<String, Long> getNumOfPracticedPerRegion(List<PracticeItem> items) {
        return items.stream()
                .collect(Collectors.groupingBy(PracticeItem::getRegion, Collectors.counting()));
    }

}

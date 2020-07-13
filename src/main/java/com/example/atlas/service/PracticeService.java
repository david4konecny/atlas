package com.example.atlas.service;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.model.Region;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface PracticeService {
    void saveAll(List<PracticeItem> items);
    List<PracticeItem> getPracticeByRegion(String username, String region);
    List<PracticeItem> getItemsByRegionSortedByNextReview(String region, String username);
    void increaseMemoryStrength(Long id);
    void resetMemoryStrength(Long id);
    void addPracticeItem(String username, String country, String region);
    Region getRegionByName(String region);
    Collection<Region> getAllRegions();
    String getRegionName(String regionId);
    Map<String, Long> getNumOfItemsForPracticeByRegion(String username);
}

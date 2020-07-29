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
    void increaseMemoryStrength(Long itemId, String username);
    void resetMemoryStrength(Long itemId, String username);
    void addPracticeItem(String username, String country, String region);
    Region getRegionById(String regionId);
    Collection<Region> getAllRegions();
    String getRegionName(String regionId);
    Map<String, Long> getNumOfItemsForPracticeByRegion(String username);
}

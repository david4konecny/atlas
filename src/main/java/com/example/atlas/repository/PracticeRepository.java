package com.example.atlas.repository;

import com.example.atlas.model.PracticeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PracticeRepository extends JpaRepository<PracticeItem, Long> {

    @Query("select p from PracticeItem p where p.region = ?1")
    List<PracticeItem> getPracticeByRegion(String region);

    @Query("select p from PracticeItem p where p.region = ?1 and p.nextReview <= CURRENT_DATE")
    List<PracticeItem> getPracticeByRegionForToday(String region);

}

package com.example.atlas.repository;

import com.example.atlas.model.PracticeItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracticeRepository extends JpaRepository<PracticeItem, Long> {

    List<PracticeItem> findByUsernameAndRegion(String username, String region);

    List<PracticeItem> findByUsernameAndRegionOrderByNextReview(String username, String region);

}

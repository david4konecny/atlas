package com.example.atlas.repository;

import com.example.atlas.model.PracticeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository extends JpaRepository<PracticeItem, Long> {
}

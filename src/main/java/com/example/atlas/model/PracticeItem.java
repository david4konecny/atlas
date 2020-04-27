package com.example.atlas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PracticeItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String countryCode;
    private String region;
    private Integer memoryStrength;
    private LocalDate nextReview;

    public PracticeItem() {
    }

    public PracticeItem(String countryCode, String region, LocalDate nextReview) {
        this.countryCode = countryCode;
        this.region = region;
        this.nextReview = nextReview;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getMemoryStrength() {
        return memoryStrength;
    }

    public void setMemoryStrength(Integer memoryStrength) {
        this.memoryStrength = memoryStrength;
    }

    public LocalDate getNextReview() {
        return nextReview;
    }

    public void setNextReview(LocalDate nextReview) {
        this.nextReview = nextReview;
    }
}

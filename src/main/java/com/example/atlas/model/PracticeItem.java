package com.example.atlas.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username", "country"}))
public class PracticeItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String country;
    private String region;
    private Integer memoryStrength;
    private LocalDate nextReview;

    public PracticeItem() {
    }

    public PracticeItem(String username, String country, String region) {
        this(username, country, region, 0, null);
    }

    public PracticeItem(String username, String country, String region, Integer memoryStrength, LocalDate nextReview) {
        this.username = username;
        this.country = country;
        this.region = region;
        this.memoryStrength = memoryStrength;
        this.nextReview = nextReview;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {
        return "PracticeItem{" +
                "id=" + id +
                ", countryCode='" + country + '\'' +
                ", region='" + region + '\'' +
                ", memoryStrength=" + memoryStrength +
                ", nextReview=" + nextReview +
                '}';
    }
}

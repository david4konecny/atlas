package com.example.atlas;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private @Autowired PracticeService practiceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addSampleData();
        System.out.println(practiceService.getPracticeByRegion("europe"));
    }

    private void addSampleData() {
        List<PracticeItem> items = new ArrayList<>();
        Collections.addAll(items,
                new PracticeItem("AUT", "europe", LocalDate.now()),
                new PracticeItem("CHE", "europe", LocalDate.now()),
                new PracticeItem("DNK", "europe", LocalDate.now()),
                new PracticeItem("-99", "europe", LocalDate.now()),
                new PracticeItem("CYP", "europe", LocalDate.now().plusDays(1L)),
                new PracticeItem("DEU", "europe", LocalDate.now().plusDays(1L)),
                new PracticeItem("ESP", "europe", LocalDate.now().plusDays(2L))
        );
        practiceService.saveAll(items);
    }

}

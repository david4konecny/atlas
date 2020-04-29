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
    }

    private void addSampleData() {
        List<PracticeItem> items = new ArrayList<>();
        Collections.addAll(items,
                new PracticeItem("joe", "Denmark", "europe", LocalDate.now()),
                new PracticeItem("joe", "Northern Cyprus", "europe", LocalDate.now()),
                new PracticeItem("joe", "Cyprus", "europe", LocalDate.now().plusDays(1L)),
                new PracticeItem("joe", "Germany", "europe", LocalDate.now().plusDays(1L)),
                new PracticeItem("frank", "Spain", "europe", LocalDate.now().plusDays(2L))
        );
        PracticeItem item1 = new PracticeItem("frank", "Austria", "europe", LocalDate.now());
        item1.setMemoryStrength(2);
        PracticeItem item2 = new PracticeItem("frank", "Switzerland", "europe", LocalDate.now());
        item2.setMemoryStrength(5);
        Collections.addAll(items, item1, item2);
        practiceService.saveAll(items);
    }

}

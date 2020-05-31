package com.example.atlas;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private @Autowired PracticeService practiceService;
    private @Autowired UserDetailsManager users;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

    private void addSampleData() {
        List<PracticeItem> items = new ArrayList<>();
        Collections.addAll(items,
                new PracticeItem("joe", "Denmark", "europe", 1, LocalDate.now()),
                new PracticeItem("joe", "Northern Cyprus", "europe", 1, LocalDate.now()),
                new PracticeItem("joe", "Cyprus", "europe", 2, LocalDate.now().plusDays(1L)),
                new PracticeItem("joe", "Germany", "europe", 3, LocalDate.now().plusDays(1L)),
                new PracticeItem("frank", "Spain", "europe", 3, LocalDate.now().plusDays(2L)),
                new PracticeItem("frank", "Austria", "europe", 2, LocalDate.now()),
                new PracticeItem("frank", "Australia", "oceania", 5, LocalDate.now()),
                new PracticeItem("frank", "Switzerland", "europe", 10, LocalDate.now())
        );
        Collections.addAll(items);
        practiceService.saveAll(items);
    }

    private void addSampleUsers() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("joe")
                .password("test")
                .roles("USER")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("frank")
                .password("test")
                .roles("USER")
                .build();
        users.createUser(user1);
        users.createUser(user2);
    }

}

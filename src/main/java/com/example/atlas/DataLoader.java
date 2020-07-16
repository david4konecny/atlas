package com.example.atlas;

import com.example.atlas.model.PracticeItem;
import com.example.atlas.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private @Autowired PracticeService practiceService;
    private @Autowired PasswordEncoder passwordEncoder;
    private @Autowired UserDetailsManager userDetailsManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addSampleUsers();
        addSampleData();
    }

    private void addSampleData() {
        List<PracticeItem> items = new ArrayList<>();
        Collections.addAll(items,
                new PracticeItem("joe", "Denmark", "europe", 1, LocalDate.now()),
                new PracticeItem("joe", "Northern Cyprus", "europe", 1, LocalDate.now()),
                new PracticeItem("joe", "Cyprus", "europe", 2, LocalDate.now().plusDays(1L)),
                new PracticeItem("joe", "Germany", "europe", 3, LocalDate.now().plusDays(1L))
        );
        Collections.addAll(items);
        practiceService.saveAll(items);
    }

    private void addSampleUsers() {
        UserDetails user = User.withUsername("joe")
                .password(passwordEncoder.encode("test"))
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);
    }

}

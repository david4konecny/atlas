package com.example.atlas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MainNavigationControllerTest {

    private MockMvc mockMvc;
    private MainNavigationController controller = new MainNavigationController();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void home_ReturnsIndexView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }

}
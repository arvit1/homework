package com.upwork.interview.homework;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
class HomeworkApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity(springSecurityFilterChain)).build();
    }

    @DisplayName("Test checkin id student is already checked in")
    @Test
    void testCheckIn() throws Exception {
        mockMvc.perform(get("/api/checkin?activityId=" + 1)
                .with(httpBasic("admin", "admin"))
                .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.students", Matchers.hasSize(2)));
    }

    @DisplayName("Test checkin id student is added")
    @Test
    void testCheckInPerform() throws Exception {
        mockMvc.perform(get("/api/checkin?activityId=" + 1)
                .with(httpBasic("john", "john"))
                .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.students", Matchers.hasSize(3)));
    }

}

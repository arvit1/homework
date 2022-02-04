package com.upwork.interview.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class HomeworkApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test checkin id student is added")
    @Test
    void testCheckIn() throws Exception {
        String expectedString = "{\"activityId\":1,\"name\":\"Math\",\"start\":\"2022-02-04T10:00:00\",\"end\":\"2022-02-04T10:50:00\",\"students\":[{\"studentId\":3,\"fullName\":\"Admin Me\",\"username\":\"admin\",\"password\":\"$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.\",\"enabled\":true},{\"studentId\":2,\"fullName\":\"John Watson\",\"username\":\"john\",\"password\":\"$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea\",\"enabled\":true},{\"studentId\":1,\"fullName\":\"Patrick Pwayze\",\"username\":\"patrick\",\"password\":\"$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.\",\"enabled\":true}]}";

        mockMvc.perform(get("/api/checkin?activityId=" + 1)
                .with(httpBasic("admin", "admin"))
                .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedString));
    }

    @DisplayName("Test checkin id student is already checked in")
    @Test
    void testCheckInPerform() throws Exception {
        String expectedString = "{\"activityId\":1,\"name\":\"Math\",\"start\":\"2022-02-04T10:00:00\",\"end\":\"2022-02-04T10:50:00\",\"students\":[{\"studentId\":2,\"fullName\":\"John Watson\",\"username\":\"john\",\"password\":\"$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea\",\"enabled\":true},{\"studentId\":1,\"fullName\":\"Patrick Pwayze\",\"username\":\"patrick\",\"password\":\"$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.\",\"enabled\":true}]}";

        mockMvc.perform(get("/api/checkin?activityId=" + 1)
                .with(httpBasic("john", "john"))
                .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedString));
    }

}

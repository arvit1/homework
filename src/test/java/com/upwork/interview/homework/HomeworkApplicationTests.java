package com.upwork.interview.homework;

import com.upwork.interview.homework.model.Activity;
import com.upwork.interview.homework.repo.ActivityRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
class HomeworkApplicationTests {

	@Autowired
	private ActivityRepo activityRepo;

	@DisplayName("Test checkin")
	@Test
	@WithMockUser(value = "admin")
	void testCheckIn() {
		Activity activity = activityRepo.findById(1L).get();
		System.out.println(activity);
	}

}

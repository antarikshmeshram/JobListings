package com.org.jobs.joblistings;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class JoblistingsApplicationTests {

	public static Logger logger = LoggerFactory.getLogger(JoblistingsApplication.class);

	@Test
	void contextLoads() {
		logger.info("Tests initialized.....");

		logger.info("Tests initialized again.....");
		assertEquals(true, true);
	}
}

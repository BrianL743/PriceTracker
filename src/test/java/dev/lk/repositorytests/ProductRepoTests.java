package dev.lk.repositorytests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes=dev.lk.app.PriceTrackerApplication.class)
class ProductRepoTests {

	@Test
	void contextLoads() {
	}

}

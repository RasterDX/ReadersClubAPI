package edu.uaic.ReadersClubAPI;

import edu.uaic.ReadersClubAPI.services.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadersClubApiApplicationTests {

	@Autowired
	LocationService locationService;

	@Test
	void contextLoads() {
		System.out.println(locationService.calculateDistance(5.4253, 3.0412, 50.0359, 58.3838));

	}

}

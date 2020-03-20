package edu.uaic.ReadersClubAPI;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.repository.UserRepository;
import edu.uaic.ReadersClubAPI.services.LocationService;
import edu.uaic.ReadersClubAPI.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReadersClubApiApplicationTests {

	@Autowired
	LocationService locationService;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;


	@Test
	void contextLoads() {
		System.out.println(locationService.calculateDistance(5.4253, 3.0412, 50.0359, 58.3838));
	}

	@Test
	void apiJpaTest() {
		List<UserModel> users = new ArrayList<>();
		UserModel user = new UserModel("a","a", "a@emai.com", "passs");
		users.add(user);

 		user.getBooks().add(new BookModel("carta", "de autor", "imaigne"));

		userRepository.saveAll(users);

		assert user.getBooks() != null;
	}

}

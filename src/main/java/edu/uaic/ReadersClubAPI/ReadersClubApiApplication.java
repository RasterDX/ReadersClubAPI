package edu.uaic.ReadersClubAPI;

import edu.uaic.ReadersClubAPI.models.Location;
import edu.uaic.ReadersClubAPI.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReadersClubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadersClubApiApplication.class, args);
	}
}

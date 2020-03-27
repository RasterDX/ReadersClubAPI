package edu.uaic.ReadersClubAPI;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.Location;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import edu.uaic.ReadersClubAPI.repository.LocationRepository;
import edu.uaic.ReadersClubAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 *  Runs after Spring initializes all tables
 *  Used to mock data
 */
@Component
class InitilizerRunner implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void run(String... args) throws Exception {
        addTestUser();
        addTestBooks();
        addLocationsTest();
        System.out.println("INITIALIZATION DONE");
    }


    private void addTestBooks() {
        List<BookModel> mockData = new ArrayList<>();
        mockData.add(new BookModel("Amintiri din copilarie", "Ion creanga", "https://www.libris.ro/img/pozeprod/59/1002/96/628336.jpg"));
        mockData.add(new BookModel("Morometii", "Marin Preda", "https://upload.wikimedia.org/wikipedia/ro/7/7c/Morometii_afis.jpg"));
        mockData.add(new BookModel("Ion", "Liviu Rebreanu", "https://www.libris.ro/img/pozeprod/59/1002/C0/1163390.jpg"));
        mockData.add(new BookModel("Maitreyi", "Mircea Eliade", "https://upload.wikimedia.org/wikipedia/ro/thumb/4/45/Maitreyi.jpg/200px-Maitreyi.jpg"));
        mockData.add(new BookModel("La medeleni", "Ionel Teodoreanu", "https://www.anticariat-logos.ro/wp-content/uploads/2016/07/La-Medeleni-Ionel-Teodoreanu-Editura-Eminescu-1984-vol-1.jpg"));
        mockData.add(new BookModel("Amintiri din copilarie", "Ion creanga", "https://www.libris.ro/img/pozeprod/59/1002/96/628336.jpg"));
        mockData.add(new BookModel("Amintiri din copilarie", "Ion creanga", "https://www.libris.ro/img/pozeprod/59/1002/96/628336.jpg"));
        bookRepository.saveAll(mockData);
    }


    private void addTestUser() {
        userRepository.save(new UserModel("Test", "Test", "test@email.com", "test"));
        userRepository.save(new UserModel("Test1", "Test1", "test1@email.com", "test1"));
    }

    private void addLocationsTest() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location("Palatul Culturii", 27.586961, 47.157484, "https://lh5.googleusercontent.com/p/AF1QipOetoBmZbNUbPlXnVtAIOX4AtDWC1bT3C8vR-5F=w408-h306-k-no"));
        locationList.add(new Location("Opera Nationala", 27.5846, 47.1648, "https://lh5.googleusercontent.com/p/AF1QipNlFRKhCV1bi58DsI0aVHdCMNB1vOpn1lCQ60nH=w408-h306-k-no"));
        locationList.add(new Location("Facultatea de Informatica Iasi", 27.5749, 47.1743, "https://lh5.googleusercontent.com/p/AF1QipNaqXprrYIrDTIkCJJgAqVxtlOakSmrmuJbNVrV=w408-h306-k-no"));
        locationList.add(new Location("Stadionul Emil Alexandrescu", 27.561220, 47.184661, "https://lh5.googleusercontent.com/p/AF1QipOrLTZGzhtPoz2WaknWXQ90Y0oSGc8qdfO-UDAE=w408-h306-k-no"));
        locationList.add(new Location("Parcul Expozitiei", 27.560447, 47.186580, "https://lh5.googleusercontent.com/p/AF1QipN-VtS4jMDLRzZvGdv3l_rXa8tma7uy47pHCbIb=w408-h306-k-no"));
        locationList.add(new Location("Intrare Gradina Botanica", 27.557635, 47.186579, "https://lh5.googleusercontent.com/p/AF1QipNsVDjI1vcd_c5q7zzwJUl9vycioqjgUdKqDx8U=w408-h544-k-no"));
        locationList.add(new Location("Statuia Ecvestra a lui Mihai Viteazu", 27.562877, 47.186462, "https://lh5.googleusercontent.com/p/AF1QipMQXurS_WngaFQNvCcN5xksF5hg0VL0uEWaqXtk=w408-h272-k-no"));
        locationList.add(new Location("Parcul Copou", 27.567240, 47.179334, "https://lh5.googleusercontent.com/p/AF1QipPuRLo-Chd0u1YxjZ51QiJD2DLsT391JmXjM2rP=w408-h306-k-no"));
        locationList.add(new Location("Teiul lui Eminescu", 27.566720, 47.178433, "https://lh5.googleusercontent.com/p/AF1QipMmqz-aW3OMLYvRJf_lvlXW0tEtvTwSH9NSUFT_=w408-h544-k-no"));
        locationRepository.saveAll(locationList);
    }

}
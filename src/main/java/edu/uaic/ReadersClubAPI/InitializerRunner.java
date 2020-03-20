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
    }

    private void addLocationsTest() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location("Palatul Culturii", 27.586961, 47.157484));
        locationList.add(new Location("Opera Nationala", 27.5846, 47.1648));
        locationList.add(new Location("Facultatea de Informatica Iasi", 27.5749, 47.1743));
        locationList.add(new Location("Stadionul Emil Alexandrescu", 27.561220, 47.184661));
        locationList.add(new Location("Parcul Expozitiei", 27.560447, 47.186580));
        locationList.add(new Location("Intrare Gradina Botanica", 27.557635, 47.186579));
        locationList.add(new Location("Statuia Ecvestra a lui Mihai Viteazu", 27.562877, 47.186462));
        locationList.add(new Location("Parcul Copou", 27.567240, 47.179334));
        locationList.add(new Location("Teiul lui Eminescu", 27.566720, 47.178433));
        locationRepository.saveAll(locationList);
    }

}
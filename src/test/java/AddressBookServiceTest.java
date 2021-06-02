import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressBookServiceTest {
    @Test
    public void givenAddressBookDetailsDB_WhenRetrieved_ShouldMatchCountOfRecords() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> personDetailsList = addressBookService.readAddressBookDatabaseData();
        System.out.println(personDetailsList);
        Assertions.assertEquals(4, personDetailsList.size());
    }

    @Test
    public void givenCityFromAddressBook_WhenRetrieved_ShouldReturnTheResult() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> personDetailsList = addressBookService.getDataByCity("Pune");
        System.out.println(personDetailsList);
        Assertions.assertEquals(2, personDetailsList.size());
    }

    @Test
    public void givenParticularPeriod_WhenRetrieved_ShouldReturnResult() {
        AddressBookService addressBookService = new AddressBookService();
        LocalDate startDate = LocalDate.of(2017, 05, 25);
        LocalDate endDate = LocalDate.now();
        List<PersonDetails> personDetailsList = addressBookService.getAddressBookByParticularPeriod(startDate, endDate);
        System.out.println(personDetailsList);
        Assertions.assertEquals(4, personDetailsList.size());
    }

    @Test
    public void givenNewInformationToAddressBook_WhenUpdated_ShouldSyncWithDBUsing() {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.updatePersonData("Rohini","Chinchwad");
        boolean result = addressBookService.checkAddressBookInSynWithDB("Rohini");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenNewContactToAddressBook_WhenAdded_ShouldReturnResult() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> personDetailsList;
        addressBookService.readAddressBookDatabaseData();
        addressBookService.addNewContactToAddressBook("Rahul", "Singh", "Seawood", "Mumbai", "Maharastra", 1234, 8989, "rahul16@gmail.com", LocalDate.now());
        personDetailsList = addressBookService.readAddressBookDatabaseData();
        Assertions.assertEquals(5,personDetailsList.size());
    }

    @Test
    public void givenContacts_WhenAddedToDB_ShouldMatchAddressBookData() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> personDetailsList;
        PersonDetails[] arrayOfContacts = {
            new PersonDetails(0, "Sachin", "Tendulkar", "Hsr", "Bangalore", "Karnataka", 5678, 9786, "sachin12@gmail.com",LocalDate.now()),
            new PersonDetails(0, "Virat", "Kohli", "Marunji", "Pune", "Maharastra", 5679, 9787, "kohli12@gmail.com",LocalDate.now()),
            new PersonDetails(0, "Rahul", "Dravid", "Abc", "Shimla", "Himachal Pradesh", 5670, 9789, "Dravid12@gmail.com",LocalDate.now()),
            new PersonDetails(0, "Mahenra", "Dhoni", "Xyz", "Patna", "Bihar", 5670, 9789, "Dravid12@gmail.com",LocalDate.now())
        };
        Instant start = Instant.now();
        addressBookService.addAddressBookData(Arrays.asList(arrayOfContacts));
        Instant end = Instant.now();
        System.out.println("Duration Thread: "+ Duration.between(start, end));
        personDetailsList = addressBookService.readAddressBookDatabaseData();
        Assertions.assertEquals(8, personDetailsList.size());
    }
}

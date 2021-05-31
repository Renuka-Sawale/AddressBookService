import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
}

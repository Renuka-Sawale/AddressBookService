import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {
    @Test
    public void givenAddressBookDetailsDB_WhenRetrieved_ShouldMatchCountOfRecords() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> personDetailsList = addressBookService.readAddressBookDatabaseData();
        System.out.println(personDetailsList);
        Assertions.assertEquals(4, personDetailsList.size());
    }
}

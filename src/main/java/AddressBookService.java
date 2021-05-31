import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
    private PreparedStatement AddressBookPrepareStatement;

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_transaction?user=root";
        String userName = "root";
        Connection connection;
        System.out.println("Connecting to database " +jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, "Renuka@1994");
        System.out.println("Connection is Successful! " +connection);
        return connection;
    }

    public List<PersonDetails> readAddressBookDatabaseData() {
        String sql = "select * from address_book_details; ";
        return this.getAddressBookDataUsingDB(sql);
    }

    private List<PersonDetails> getAddressBookDataUsingDB(String sql) {
        List<PersonDetails> personDetailsList = new ArrayList<>();
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            personDetailsList = this.getAddressBookServiceData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personDetailsList;
    }

    private List<PersonDetails> getAddressBookServiceData(ResultSet resultSet) {
        List<PersonDetails> personDetailsList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                long phoneNo = resultSet.getLong("phoneNo");
                String email = resultSet.getString("email");
                personDetailsList.add(new PersonDetails(id, firstName, lastName, address, city, state, zip, phoneNo, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personDetailsList;
    }

    public List<PersonDetails> getDataByCity(String City) {
        String sql = String.format("select * from address_book_details where city = '%s'; ", City);
        return this.getAddressBookDataUsingDB(sql);
    }

    public List<PersonDetails> getAddressBookByParticularPeriod(LocalDate startDate, LocalDate endDate) {
        String sql = String.format("select * from address_book_details where startDate between '%s' and '%s'",
                Date.valueOf(startDate), Date.valueOf(endDate));
        return this.getAddressBookDataUsingDB(sql);
    }

    public int updatePersonData(String firstName, String address) {
        String query = String.format("update address_book_details set address = '%s' where firstName = '%s';", address, firstName);
        try(Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<PersonDetails> getAddressBookData(String firstName) {
        List<PersonDetails> addressBookList = null;
        if (this.AddressBookPrepareStatement == null)
            this.prepareStatementForAddressBook();
        try {
            AddressBookPrepareStatement.setString(1,firstName);
            ResultSet resultSet = AddressBookPrepareStatement.executeQuery();
            addressBookList = this.getAddressBookServiceData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    public boolean checkAddressBookInSynWithDB(String firstName) {
        List<PersonDetails> personDetailsList = this.getAddressBookData(firstName);
        return personDetailsList.equals(getAddressBookData(firstName));
    }

    private void prepareStatementForAddressBook() {
        try {
            Connection connection = this.getConnection();
            String sql = "select * from address_book_details where firstName = ?";
            AddressBookPrepareStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

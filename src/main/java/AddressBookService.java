import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
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
        String query = "select * from address_book_details; ";
        List<PersonDetails> personDetailsList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personDetailsList;
    }
}

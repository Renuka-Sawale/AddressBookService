import java.time.LocalDate;
import java.util.Objects;

public class PersonDetails {
    public int id;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public int zip;
    public long phoneNo;
    public String email;
    public LocalDate startDate;

    public PersonDetails(int id, String firstName, String lastName, String address, String city, String state, int zip, long phoneNo, String email, LocalDate startDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;
        this.startDate = startDate;
    }

    public PersonDetails(int id, String firstName, String lastName, String address, String city, String state, int zip, long phoneNo, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNo=" + phoneNo +
                ", email='" + email + '\'' +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDetails that = (PersonDetails) o;
        return id == that.id && zip == that.zip && phoneNo == that.phoneNo && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(email, that.email) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, city, state, zip, phoneNo, email, startDate);
    }
}

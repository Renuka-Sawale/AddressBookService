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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDetails that = (PersonDetails) o;
        return id == that.id && zip == that.zip && phoneNo == that.phoneNo && firstName.equals(that.firstName) && lastName.equals(that.lastName) && address.equals(that.address) && city.equals(that.city) && state.equals(that.state) && email.equals(that.email);
    }
}

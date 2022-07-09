public class AcademicMember {
    private String firstName;
    private String lastName;

    public AcademicMember(String firstName, String lastName) {
        setFirtName(firstName);
        setLastName(lastName);
    }

    public String getFirtName() {
        return firstName;
    }

    public void setFirtName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Nome: " + this.firstName + " " + this.lastName + "\n";
    }
}

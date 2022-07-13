/**
 * Abstraction of a person.
 */
public abstract class Person {
    private String fullName;
    private String cpf;
    private String address;
    private String mobilePhone;
    private String email;

    /**
     * Constructor of Person.
     *
     * @param fullName the full name
     * @param cpf the cpf
     * @param address the address
     * @param mobilePhone the mobile phone
     * @param email the email
     */
    public Person(String fullName, String cpf, String address, String mobilePhone, String email) {
        setFullName(fullName);
        setCpf(cpf);
        setAddress(address);
        setMobilePhone(mobilePhone);
        setEmail(email);
    }

    public String getFullName() {
        return fullName;
    }

    /**
     * Set the person's full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        if (fullName.split(" ").length < 2) {
            throw new IllegalArgumentException("Name must have at least two components");
        }
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    /**
     * Set the person's document.
     *
     * @param cpf the cpf
     */
    public void setCpf(String cpf) {
        if (!cpf.trim().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF invalid");
        }
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Set the person's mobile phone.
     *
     * @param mobilePhone the mobile phone
     */
    public void setMobilePhone(String mobilePhone) {
        if (!mobilePhone.trim().matches("\\(\\d{2}\\)\\d{5}-\\d{4}")) {
            throw new IllegalArgumentException("mobilePhone invalid");
        }
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

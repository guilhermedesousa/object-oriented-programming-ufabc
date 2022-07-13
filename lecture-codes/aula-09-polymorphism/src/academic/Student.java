package academic;

public class Student extends AcademicMember implements Comparable<Student> {
    private String ra;
    private String course;
    private int idade;

    public Student(String firstName, String lastName, String ra, String course, int idade) {
        super(firstName, lastName);
        setRa(ra);
        setCourse(course);
        setIdade(idade);
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return super.toString() + "RA: " + this.ra + "\n"
                + "Course: " + this.course + "\n";
    }

    @Override
    public boolean equals(Object o) {
        // compare identities
        if (this == o) {
            return true;
        }

        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;
        
        return this.getRa().equals(student.getRa());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // @Override
    // public int compareTo(Student student) {
    //     return this.getRa().compareTo(student.getRa());
    // }

    @Override
    public int compareTo(Student student) {
        if (this.getIdade() > student.getIdade()) {
            return 1;
        } else if (this.getIdade() < student.getIdade()) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Student extends AcademicMember {
    private String ra;
    private String course;

    public Student(String firstName, String lastName, String ra, String course) {
        super(firstName, lastName);
        setRa(ra);
        setCourse(course);
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

    @Override
    public String toString() {
        return super.toString() + "RA: " + this.ra + "\n"
                + "Course: " + this.course + "\n";
    }
}

public class StudentEntity {

    private int studentId;
    private String fullName;
    private String email;
    private String department;

    public StudentEntity(String fullName,
                         String email,
                         String department) {
        this.fullName = fullName;
        this.email = email;
        this.department = department;
    }

    public StudentEntity(int studentId,
                         String fullName,
                         String email,
                         String department) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }
}

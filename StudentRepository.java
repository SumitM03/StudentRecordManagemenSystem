import java.sql.*;

public class StudentRepository {

    private Connection con = DatabaseUtil.connect();

    // ADD STUDENT
    public void registerStudent(StudentEntity student) {
        try {
            String sql =
              "INSERT INTO student_records(full_name,email,department) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getFullName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDepartment());
            ps.executeUpdate();
            System.out.println("Student registered successfully");
        } catch (Exception e) {
            System.out.println("Error while registering student");
            e.printStackTrace();
        }
    }

    // VIEW ALL
    public void fetchAllStudents() {
        try {
            Statement st = con.createStatement();
            ResultSet rs =
              st.executeQuery("SELECT * FROM student_records");

            System.out.println("\nID | NAME | EMAIL | DEPARTMENT");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("full_name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("department")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BY ID
    public void findStudentById(int id) {
        try {
            String sql =
              "SELECT * FROM student_records WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("full_name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("department")
                );
            } else {
                System.out.println("Student not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE DEPARTMENT
    public void updateDepartment(int id, String dept) {
        try {
            String sql =
              "UPDATE student_records SET department=? WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dept);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Department updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE RECORD
    public void removeStudent(int id) {
        try {
            String sql =
              "DELETE FROM student_records WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student record deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

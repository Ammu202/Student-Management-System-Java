import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Insert student
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setGrade(rs.getString("grade"));
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // Update student
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());
            stmt.setInt(4, student.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with that ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with that ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

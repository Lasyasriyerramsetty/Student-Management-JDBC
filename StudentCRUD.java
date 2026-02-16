package myProject;


import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "root123";   

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n--- STUDENT CRUD MENU ---");
                System.out.println("1. Insert Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        String insertQuery = "INSERT INTO students VALUES (?, ?, ?, ?)";
                        PreparedStatement psInsert = con.prepareStatement(insertQuery);
                        psInsert.setInt(1, id);
                        psInsert.setString(2, name);
                        psInsert.setString(3, email);
                        psInsert.setString(4, course);

                        psInsert.executeUpdate();
                        System.out.println("Student Inserted Successfully!");
                        break;

                    case 2:
                        String selectQuery = "SELECT * FROM students";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\nID\tName\tEmail\tCourse");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("email") + "\t" +
                                    rs.getString("course")
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        String updateQuery = "UPDATE students SET name=? WHERE id=?";
                        PreparedStatement psUpdate = con.prepareStatement(updateQuery);
                        psUpdate.setString(1, newName);
                        psUpdate.setInt(2, updateId);

                        int rows = psUpdate.executeUpdate();
                        if (rows > 0)
                            System.out.println("Student Updated Successfully!");
                        else
                            System.out.println("Student Not Found!");
                        break;

                    case 4:
                        System.out.print("Enter ID to Delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM students WHERE id=?";
                        PreparedStatement psDelete = con.prepareStatement(deleteQuery);
                        psDelete.setInt(1, deleteId);

                        int deleted = psDelete.executeUpdate();
                        if (deleted > 0)
                            System.out.println("Student Deleted Successfully!");
                        else
                            System.out.println("Student Not Found!");
                        break;

                    case 5:
                        con.close();
                        System.out.println("Connection Closed.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

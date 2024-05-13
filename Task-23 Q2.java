import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Test"; 
        String username = "test"; 
        String password = "MySql@2024"; 

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO your_table_name (empcod, empnam, empage, esalar) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Data to be inserted
            String[] empcodes = {"101", "102", "103", "104", "105"};
            String[] empnames = {"Jenny", "Jacky", "Joe", "John", "Shameer"};
            int[] empages = {25, 30, 20, 40, 25};
            int[] esalars = {10000, 20000, 40000, 80000, 90000};

            // Insert data into the table
            for (int i = 0; i < empcodes.length; i++) {
                statement.setString(1, empcodes[i]);
                statement.setString(2, empnames[i]);
                statement.setInt(3, empages[i]);
                statement.setInt(4, esalars[i]);
                statement.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}

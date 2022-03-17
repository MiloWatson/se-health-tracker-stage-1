import java.sql.*;

public class Connect{
    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:D:\\UEA\\Year 2\\Software Development\\se-health-tracker-group-14\\Tracker Database\\healthtracker.db";
            // replace everything after jdbc:sqlite: with location of healthtracker.db file
            conn = DriverManager.getConnection(url);

            System.out.println("Connection established!");
            Statement state = null;
            String query = "SELECT * FROM users";
            try {
                state = conn.createStatement();
                ResultSet rs = state.executeQuery(query);
                while (rs.next()){
                    String name = rs.getString("first_name");
                    System.out.println(name);
                }
            }
            catch (SQLException e) {
                throw new Error("Problem", e);
            }
            finally {
                if (state != null) {
                    state.close();
                }
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        connect();
    }
}



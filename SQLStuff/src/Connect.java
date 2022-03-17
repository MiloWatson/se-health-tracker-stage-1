import java.sql.*;

public class Connect{
    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\sqlite\\chinook.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connection established!");
            Statement state = null;
            String query = "Select albumid, title from albums order by title limit 10;";
            try {
                state = conn.createStatement();
                ResultSet rs = state.executeQuery(query);
                while (rs.next()){
                    String name = rs.getString("title");
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



package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

public class AdminMapper {
    static List<Materials> getAll(ConnectionPool connectionPool) throws DatabaseException {
        List<User> userList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");
        User user;

        String sql = "SELECT * FROM user";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String role = rs.getString("role");
                    String password = rs.getString("password");
                    int credit = rs.getInt("credit");
                    user = new User(username, password, role, credit);
                    userList.add(user);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Something went wrong with the database");
        }
        return userList;
    }

}

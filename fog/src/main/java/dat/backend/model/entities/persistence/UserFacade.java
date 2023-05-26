package dat.backend.model.entities.persistence;

import dat.backend.model.entities.entities.User;
import dat.backend.model.entities.exceptions.DatabaseException;

import java.util.List;

public class UserFacade {

    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.createUser(username, password, role, connectionPool);
    }

}

package repositories;

import models.Users;

public interface ErsUsersDAO {
    Users getUserGivenUsername(String username);
}

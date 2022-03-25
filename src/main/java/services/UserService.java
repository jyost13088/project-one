
package services;
import models.Users;
import repositories.*;

public class UserService {
    private ErsUsersDAO userDAO;

    public UserService(ErsUsersDAO userDAO){

        this.userDAO = userDAO;
    }

    public UserService(){

        this.userDAO = new ErsUsersDAOImpl();
    }


    public Users validateCredentials(String username, String password) {
        Users user = this.userDAO.getUserGivenUsername(username);
        //user wasnt found so return null
        if (user == null)
            return null;

        if (!password.equals(user.getPassword()))
            return null;

        return user;
    }
}

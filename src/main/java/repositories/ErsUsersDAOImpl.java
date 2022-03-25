package repositories;

import models.Users;
import util.Connectionutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ErsUsersDAOImpl implements ErsUsersDAO {

    public Users getUserGivenUsername(String username){
    Users user = null;

        try (Connection conn = Connectionutil.getConnection()){
        String sql="select * from ers_users where ers_username = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            user = new Users(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7)
            );
        }
    }catch (SQLException sqle){
        sqle.printStackTrace();
    }
        return user;
}

    public void createUser(Users user) {
        try (Connection conn = Connectionutil.getConnection()) {
            String sql = "Insert into ers_users (ers_username, ers_password , user_first_name, ers_last_name, user_email, user_role_id_fk) values(?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRole_Id_fk());

            ps.executeUpdate();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

}

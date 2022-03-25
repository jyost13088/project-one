package models;

public class Users {
    private Integer user_Id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer role_Id_fk;

    public Users(){

    }


    public Users(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Users(Integer user_Id, String username, String password, String firstname, String lastname, String email, Integer role_Id_fk) {
        this.user_Id = user_Id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role_Id_fk = role_Id_fk;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole_Id_fk() {
        return role_Id_fk;
    }

    public void setRole_Id_fk(Integer role_Id_fk) {
        this.role_Id_fk = role_Id_fk;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_Id=" + user_Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role_Id_fk=" + role_Id_fk +
                '}';
    }
}

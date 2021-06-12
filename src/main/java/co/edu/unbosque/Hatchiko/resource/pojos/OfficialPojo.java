package co.edu.unbosque.Hatchiko.resource.pojos;

public class OfficialPojo {

    private String username;
    private String password;
    private String email;
    private String name;

    public OfficialPojo(){

    }

    public OfficialPojo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public OfficialPojo(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

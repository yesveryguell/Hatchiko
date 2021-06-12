package co.edu.unbosque.Hatchiko.resource.pojos;

public class OwnerPojo {

    private String username;
    private String password;
    private String email;
    private Long person_id;
    private String name;
    private String address;
    private String neighborhood;

    public OwnerPojo() {
    }

    public OwnerPojo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public OwnerPojo(String username, String password, String email, Long person_id, String name, String address, String neighborhood) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
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

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}

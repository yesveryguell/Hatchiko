package co.edu.unbosque.Hatchiko.resource.pojos;

public class Owner {
    private String username;
    private String name;
    private String adress;
    private String neighborhood;

    public Owner() {
    }

    public Owner(String username, String name, String adress, String neighborhood) {
        this.username = username;
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}

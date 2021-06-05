package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vet")
@NamedQueries({
        @NamedQuery(name = "Vet.findByUserName",
                query = "SELECT a FROM Vet a WHERE a.userName = :userName")
})
public class Vet {
    @Id
    @GeneratedValue
    @Column(name = "vet_id")
    private Integer vet_id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToOne
    private UserApp userApp;

    @OneToMany(mappedBy = "vet",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits = new ArrayList<>();


    public Vet(){

    }

    public Vet(String userName, String name, String address, String neighborhood) {
        this.userName = userName;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Integer getVet_id() {
        return vet_id;
    }

    public void setVet_id(Integer vet_id) {
        this.vet_id = vet_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setVet(this);
    }
}

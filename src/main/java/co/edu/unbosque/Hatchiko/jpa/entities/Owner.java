package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Owner")
@PrimaryKeyJoinColumn
public class Owner extends UserApp{

    @Column(name = "person_id", unique = true)
    private Long person_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;


    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    public Owner(){

    }

    public Owner(String username, String password, String email,Long person_id, String name, String address, String neighborhood) {
        super(username, password, email, "Owner");
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
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

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

}

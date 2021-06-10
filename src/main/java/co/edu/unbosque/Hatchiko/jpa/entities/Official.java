package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Official")
@PrimaryKeyJoinColumn
public class Official extends UserApp {

    @Column(name = "name")
    private String name;

    public Official(){

    }

    public Official(String username, String password, String email, String name) {
        super(username, password, email, "Official");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

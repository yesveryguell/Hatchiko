package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Official")
@NamedQueries({
        @NamedQuery(name = "Official.findByName",
                query = "SELECT a FROM Official a WHERE a.name = :name")
})
public class Official {
    @Id
    @GeneratedValue
    @Column(name = "official_id", unique = true)
    private String official_id;

//    @Column(name = "userName", unique = true)
//    private String userName;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "userName")
    private UserApp userApp;

    public Official(){

    }

    public Official(String userName, String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

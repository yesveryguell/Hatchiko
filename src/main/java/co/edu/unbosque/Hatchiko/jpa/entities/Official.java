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
    @Column(name = "official_id")
    private Integer official_id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "userName")
    private UserApp userApp;

    public Official(){

    }

    public Official(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOfficial_id() {
        return official_id;
    }

    public void setOfficial_id(Integer official_id) {
        this.official_id = official_id;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
}

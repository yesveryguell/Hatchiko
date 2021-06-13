package co.edu.unbosque.Hatchiko.resource.pojos;

import java.util.List;

public class PetTotalPojo {

    private String total;
    private List<PetPojo> pets;


    public PetTotalPojo(String total, List<PetPojo> pets) {
        this.total = total;
        this.pets = pets;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PetPojo> getPets() {
        return pets;
    }

    public void setPets(List<PetPojo> pets) {
        this.pets = pets;
    }
}

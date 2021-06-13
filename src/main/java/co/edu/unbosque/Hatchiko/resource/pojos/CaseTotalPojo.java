package co.edu.unbosque.Hatchiko.resource.pojos;

import java.util.List;

public class CaseTotalPojo {

    private String total;
    private List<PetCasePojo> cases;

    public CaseTotalPojo(String total, List<PetCasePojo> cases) {
        this.total = total;
        this.cases = cases;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PetCasePojo> getCases() {
        return cases;
    }

    public void setCases(List<PetCasePojo> cases) {
        this.cases = cases;
    }
}

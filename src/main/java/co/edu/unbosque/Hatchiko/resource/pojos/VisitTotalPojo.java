package co.edu.unbosque.Hatchiko.resource.pojos;

import java.util.List;

public class VisitTotalPojo {
    private String total;
    private List<VisitPojo> cases;

    public VisitTotalPojo(String total, List<VisitPojo> cases) {
        this.total = total;
        this.cases = cases;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<VisitPojo> getCases() {
        return cases;
    }

    public void setCases(List<VisitPojo> cases) {
        this.cases = cases;
    }
}

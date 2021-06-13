package co.edu.unbosque.Hatchiko.resource.pojos;

import java.util.List;

public class OwnerTotalPojo {
    private String total;
    private List<OwnerPojo> owners;

    public OwnerTotalPojo(String total, List<OwnerPojo> owners) {
        this.total = total;
        this.owners = owners;

    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<OwnerPojo> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerPojo> owners) {
        this.owners = owners;
    }
}

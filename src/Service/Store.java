package Service;

public class Store implements SupplyGenerator {

    private int amountOfsupply = 1;

    public Store(int amountOfsupply) {
        this.amountOfsupply = amountOfsupply;
    }

    public Store() {
    }

    @Override
    public int amountOfSupply() {
        return amountOfsupply;
    }

    @Override
    public int getBuildingID() {
        return 2;
    }

    @Override
    public String getConsoleRepresentation() {
        return "S";
    }
}

package Service;

public class Home implements SupplyConsumer {

    private int amountNeeded = 1;
    private int travelRange = 2;

    public Home(int amountNeeded, int travelRange) {
        this.amountNeeded = amountNeeded;
        this.travelRange = travelRange;
    }

    public Home() {
    }

    @Override
    public int amountNeeded() {
        return amountNeeded;
    }

    @Override
    public int travelRange() {
        return travelRange;
    }

    @Override
    public int getBuildingID() {
        return 1;
    }

    @Override
    public String getConsoleRepresentation() {
        return "H";
    }
}

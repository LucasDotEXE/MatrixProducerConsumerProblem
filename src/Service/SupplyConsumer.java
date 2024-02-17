package Service;

import Model.Building;

public interface SupplyConsumer extends Building {

    int amountNeeded();
    int travelRange();

}

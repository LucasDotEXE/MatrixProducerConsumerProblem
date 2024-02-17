package Model;

import Service.Home;
import Service.Store;

public class Town {

    private final Building[][] buildings;

    public Town(int[][] townData) {
        this.buildings = new Building[townData.length][townData[0].length];

        forEachBuilding((building, x, y) -> {
            int buildingID = townData[x][y];
            if (buildingID > 0) buildings[x][y] = new Home(buildingID, 2);
            if (buildingID < 0) buildings[x][y] = new Store(buildingID);
        });
            }

    private void forEachBuilding(BuildingOperator operation) {
        for (int y = 0; y < buildings.length; y++) {
            for (int x = 0; x < buildings[y].length; x++) {
                operation.exec(buildings[y][x], y, x);
            }
        }
    }
    private interface BuildingOperator {
         void exec(Building building, int y, int x);
    }

    public void PrintTown() {
        forEachBuilding((building, y, x) -> {
            String buildingString = " ";
            if (building != null) {
                buildingString = building.getConsoleRepresentation();
            }
            System.out.print(buildingString);
            if (x == buildings.length-1) System.out.println();
        });
    }
}



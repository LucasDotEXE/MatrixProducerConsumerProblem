import Simple.TownStorePlacer;

import static Simple.MatrixManipulator.forEachPosition;

public class Main {


    /*
    See README.md & Pick your level of difficulty get to coding
     */
    public static void main(String[] args) {
        int[][] townData = new int[9][9];

//        for (int x = 0; x < townData.length; x++) {
//            for (int y = 0; y < townData[x].length; y++) {
//                townData[x][y] = (x+y)%2;
//            }
//        }

        townData[0][0] = 1;
        townData[4][4] = 1;
        townData[4][5] = 1;
        townData[5][4] = 1;
        townData[5][3] = 1;
        townData[8][8] = 1;

        System.out.println("No Stores");
        printTown(townData);
        System.out.println();

        TownStorePlacer.populate(townData);

        System.out.println("With Stores");
        printTown(townData);


    }
    protected enum BuildingID {
        HOME(1, 'H'), STORE(-1, 'S'), EMPTY(0, '_');

        public final int townID;
        public final char representation;

        BuildingID(int townID, char representation) {
            this.townID = townID;
            this.representation = representation;
        }

        public static BuildingID ofTownID(int townID) {
            switch (townID) {
                case 1 -> {
                    return HOME;
                }
                case -1 -> {
                    return STORE;
                }
                default -> {
                    return EMPTY;
                }
            }
        }
    }

    private static void printTown(int[][] townData) {
        forEachPosition((locationValue, x, y) -> {
            System.out.print(BuildingID.ofTownID(locationValue).representation);
            if (x == townData[y].length-1) System.out.println();
        }, townData);
    }
}
package Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeatmapService {

    public static int[][] GenerateConsumerHeatmap(int[][] townData) {
        int[][] heatmap = MatrixManipulator.getEmptyClone(townData);

        MatrixManipulator.forEachPosition((locationValue, x, y) -> {
            if (locationValue == 1) { //Building found
                heatmap[y][x] = -1; //Marking building in heatmap
            }
        }, townData);

        MatrixManipulator.forEachPosition(((locationValue, x, y) -> {
            if (locationValue == 1) {
                ArrayList<Pair<Integer, Integer>> locationsInRange = new ArrayList<>(getLocationsInRange(townData, x, y)); //Find range of the building

                boolean storeInRange = checkForStoresInRange(townData, locationsInRange);

                if (!storeInRange) {
                    markLocationsOnHeatmap(heatmap, locationsInRange, locationValue);
                }
            }
        }), townData);

        return heatmap;
    }

    private static boolean checkForStoresInRange(int[][] townData, ArrayList<Pair<Integer, Integer>> locationsInRange) {
        for (Pair<Integer, Integer> location : locationsInRange) {
            if (townData[location.getY()][location.getX()] == -1) return true;
        }
        return false;
    }

    private static List<Pair<Integer, Integer>> getLocationsInRange(int[][] townData, int x, int y) {
        ArrayList<Pair<Integer, Integer>> locationsInRange = new ArrayList<>();

        int homeRange = Config.homeRange;
        while (homeRange > 0) {
            for (int i = 0; i < homeRange; i++) {
                Pair<Integer, Integer> locationES = new Pair<>(x + homeRange-i, y + i); //
                Pair<Integer, Integer> locationSW = new Pair<>(x - i, y + homeRange-i); //
                Pair<Integer, Integer> locationWN = new Pair<>(x - homeRange + i, y - i); //
                Pair<Integer, Integer> locationNE = new Pair<>(x + i, y - homeRange + i); //

                locationsInRange.add(locationES);
                locationsInRange.add(locationSW);
                locationsInRange.add(locationWN);
                locationsInRange.add(locationNE);
            }
            homeRange--;
        }

        return locationsInRange.stream().filter(location -> checkLocationExistsInMatrix(townData, location)).collect(Collectors.toList());
    }

    private static boolean checkLocationExistsInMatrix(int[][] townData, Pair<Integer, Integer> location) {
        //It's dirty but it works and im lazy
        try {
            int locationValue = townData[location.getY()][location.getX()]; // try to aces it to see if it exists
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    private static void markLocationsOnHeatmap(int[][] heatmap, ArrayList<Pair<Integer, Integer>> locations, int value) {
        for (Pair<Integer, Integer> location : locations) {
            if (heatmap[location.getY()][location.getX()] != -1) { //Checks if location is not a known building
                heatmap[location.getY()][location.getX()] += value;
            }
        }
    }
}

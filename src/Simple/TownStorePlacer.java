package Simple;

public class TownStorePlacer {

    public static void populate(int[][] townData) {
        int[][] heatmap = HeatmapService.GenerateConsumerHeatmap(townData);

        var posMaxValue = MatrixManipulator.getPositionMaxValue(heatmap);

        while (heatmap[posMaxValue.getY()][posMaxValue.getX()] > 0) {
            townData[posMaxValue.getY()][posMaxValue.getX()] = -1;//Set place to a store
            heatmap = HeatmapService.GenerateConsumerHeatmap(townData);
            posMaxValue = MatrixManipulator.getPositionMaxValue(heatmap);
        }
    }
}

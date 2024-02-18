package Simple;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MatrixManipulator {

    public static void printMatrix(int[][] matrix) {
        forEachPosition((locationValue, x, y) -> {
            System.out.print(locationValue);
            if (x == matrix[y].length-1) System.out.println();
        }, matrix);
    }

    public static int[][] getEmptyClone(int[][] matrix) {
        return new int[matrix.length][matrix[0].length];
    }

    public static Pair<Integer, Integer> getPositionMaxValue(int[][] matrix) {
        AtomicReference<Pair<Integer, Integer>> maxValuePosition = new AtomicReference<>(new Pair<>(0, 0));
        AtomicInteger maxValue = new AtomicInteger(Integer.MIN_VALUE);

        forEachPosition((locationValue, x, y) -> {
            if (locationValue > maxValue.get()) {
                maxValuePosition.set(new Pair<>(x, y));
                maxValue.set(locationValue);
            }
        }, matrix);

        return maxValuePosition.get();
    }

    public static void forEachPosition(PositionFunction function, int[][] matrix) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                function.execute(matrix[y][x], x, y);
            }
        }
    }


    public interface PositionFunction {
        void execute(int locationValue, int x, int y);
    }
}

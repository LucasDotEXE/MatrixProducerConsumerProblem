import Model.Town;

public class Main {


    /*
    See README.md & Pick your level of difficulty get to coding
     */
    public static void main(String[] args) {
        int[][] townData = new int[10][10];

        for (int x = 0; x < townData.length; x++) {
            for (int y = 0; y < townData[x].length; y++) {
                townData[x][y] = (x+y)%2;
            }
        }

        Town town = new Town(townData);
        town.PrintTown();

    }
}
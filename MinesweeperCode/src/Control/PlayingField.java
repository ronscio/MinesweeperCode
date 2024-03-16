package Control;

import java.util.ArrayList;
import java.util.Random;

public class PlayingField {
    private static final ArrayList<Cell> cells = new ArrayList<>();
    private static boolean lost;
    private static int sizeX;
    private static int sizeY;
    private static int numberOfBombs;
    public PlayingField(int sizeX, int sizeY, int numberOfBombs){
        PlayingField.sizeX =sizeX;
        PlayingField.sizeY =sizeY;
        PlayingField.lost = false;
        PlayingField.numberOfBombs =numberOfBombs;
        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++){
                Cell emptyCell=new Empty(i,j);
                cells.add(emptyCell);
            }
        }

    }


    public void generateBombs(){
        Random rand = new Random();
        for(int i=0; i<numberOfBombs; i++){
            int xposition = rand.nextInt(sizeX);
            int yposition= rand.nextInt(sizeY);
            if(cells.get(xposition*sizeX+yposition) instanceof Bomb){
                i--;
            }
            else
            {
                Cell bombCell = new Bomb(xposition, yposition);
                cells.set(xposition * sizeX + yposition, bombCell);
            }

        }

    }


    public void generateTouchesBombs()
    {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                int count = 0;

                // Iterate through all surrounding cells
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {

                        if (dx == 0 && dy == 0) continue; // Skip the current cell

                        int xToCheck = x + dx;
                        int yToCheck = y + dy;

                        // Check boundaries
                        if (xToCheck >= 0 && xToCheck < sizeX && yToCheck >= 0 && yToCheck < sizeY) {
                            // Check if the neighboring cell is a Bomb
                            if (cells.get(xToCheck * sizeX + yToCheck) instanceof Bomb) {
                                count++;
                            }
                        }
                    }
                }

                // Update the cell if bombs are found in the vicinity
                if (count > 0 && !(cells.get(x * sizeX + y) instanceof Bomb) && !(cells.get(x * sizeX + y) instanceof TouchesBombCell)) {
                    Cell touchesBombs = new TouchesBombCell(x, y, count);
                    cells.set(x * sizeX + y, touchesBombs);
                }
            }
        }
    }

    public void addFlag(int x, int y){
        cells.get(x*sizeX+y).setFlagged();
    }

    public void openCell(int x, int y){
        cells.get(x*sizeX+y).setOpen();
    }

    public void setLostTrue(){
        lost=true;
    }

    public boolean isLost() {
        return lost;
    }

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }


    public static ArrayList<Cell> getCells() {
        return cells;
    }

}

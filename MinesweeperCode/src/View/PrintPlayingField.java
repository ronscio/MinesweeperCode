package View;

import Control.Cell;
import Control.Empty;
import Control.PlayingField;
import Control.TouchesBombCell;

import javax.swing.*;
import java.util.ArrayList;

//import static Control.PlayingField.cells;

public class PrintPlayingField {

    private int gameAreaSizeX;
    private int gameAreaSizeY;
    private ArrayList<Cell> cellsList;

    public void printPlayingField() {
        gameAreaSizeX = PlayingField.getSizeX();
        gameAreaSizeY = PlayingField.getSizeY();
        cellsList = PlayingField.getCells();

        // Print column numbers (coordinates on the top)
        System.out.print("  "); // Space for row numbers
        for (int x = 0; x < gameAreaSizeX; x++) {
            System.out.printf("%2d ", x);
        }
        System.out.println();


        //////


        for (int y = 0; y < gameAreaSizeY; y++) {
            // Print row numbers
            System.out.printf("%2d ", y);

            for (int x = 0; x < gameAreaSizeX; x++) {
                // Check if cell is open or closed
                if (cellsList.get(x + y * gameAreaSizeX).getOpen()) {
                    // If empty
                    if (cellsList.get(x + y * gameAreaSizeX) instanceof Empty) {
                        System.out.print(" ☐ ");
                    }
                    // If touches bomb
                    else if (cellsList.get(x + y * gameAreaSizeX) instanceof TouchesBombCell touchesBombCell) {

                        System.out.print(" " + touchesBombCell.getTouchedCells() + " ");
                    }
                    // If bomb (only show if lost == true)
                    else {
                        System.out.print(" ☀ ");

                    }
                }
                // If closed
                else {
                    if (!(cellsList.get(x + y * gameAreaSizeX).getFlagged())) {
                        System.out.print(" ⏹ ");
                    } else {
                        System.out.print(" ⚐ ");
                    }
                }
            }
            System.out.println(); // New line after each row
        }
    }
}


//public class PrintPlayingField {
//
//    private int gameAreaSizeX;
//    private int gameAreaSizeY;
//    private ArrayList<Cell> cellsList;
//    public void printGameArea() {
//        gameAreaSizeX = PlayingField.getSizeX();
//        gameAreaSizeY = PlayingField.getSizeY();
//        cellsList = PlayingField.getCells();
//
//        for (int x = 0; x < gameAreaSizeX; x++)
//        {
//            for (int y = 0; y < gameAreaSizeY; y++)
//            {
//
//                //if open
//                if (!cellsList.get(x * gameAreaSizeX + y).getOpen())
//                {
//                    //if empty
//                    if (cellsList.get(x * gameAreaSizeX + y) instanceof Empty)
//                    {
//                        System.out.print("☐");
//                    }
//
//                    //if touches bomb
//                    else if(cellsList.get(x * gameAreaSizeX + y) instanceof TouchesBombCell cellTouchesBomb)
//                    {
//                        System.out.print(cellTouchesBomb.getTouchedCells());
//                    }
//
//                    //if bomb (only show if lost==true)
//                    else
//                    {
//                        System.out.print("☀");
//                    }
//                }
//
//                //if closed
//                else {
//                    if (!(cellsList.get(x * gameAreaSizeX + y).getFlagged()))
//                    {
//                        System.out.print("⏹");
//                    }
//                    else
//                    {
//                        System.out.print("⚐");
//                    }
//
//                }
//
//
//            }
//        }
//    }

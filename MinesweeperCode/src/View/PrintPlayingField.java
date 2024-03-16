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

    public void printGameArea() {
        gameAreaSizeX = PlayingField.getSizeX();
        gameAreaSizeY = PlayingField.getSizeY();
        cellsList = PlayingField.getCells();

        for (int x = 0; x < gameAreaSizeX; x++)
        {
            for (int y = 0; y < gameAreaSizeY; y++)
            {

                //if open
                if (!cellsList.get(x * gameAreaSizeX + y).getOpen())
                {
                    //if empty
                    if (cellsList.get(x * gameAreaSizeX + y) instanceof Empty)
                    {
                        System.out.print("☐");
                    }

                    //if touches bomb
                    else if(cellsList.get(x * gameAreaSizeX + y) instanceof TouchesBombCell cellTouchesBomb)
                    {
                        System.out.print(cellTouchesBomb.getTouchedCells());
                    }

                    //if bomb (only show if lost==true)
                    else
                    {
                        System.out.print("☀");
                    }
                }

                //if closed
                else {
                    if (!(cellsList.get(x * gameAreaSizeX + y).getFlagged()))
                    {
                        System.out.print("⏹");
                    }
                    else
                    {
                        System.out.print("⚐");
                    }

                }


            }
        }
    }


//    public void printGameArea() {
//        // Print the top header for column numbers
//        System.out.print("       "); // Adjust the initial spacing based on your layout
//        for (int j = 1; j <= gameAreaSizeX; j++) {
//            System.out.printf("%-3d", j); // Adjust spacing as needed to align with the grid
//        }
//        System.out.println(); // Move to the next line after printing the header
//
//        // Now print each row
//        for (int i = 0; i < gameAreaSizeY; i++) {
//            System.out.printf("%-7d", i + 1); // Print the row number with proper alignment
//            for (int j = 0; j < gameAreaSizeX; j++) {
//                System.out.print("⏹  "); // Adjust the spacing as needed
//            }
//            System.out.println(); // Move to the next line after printing the row
//        }
//    }
}

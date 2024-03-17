import Control.Bomb;
import Control.PlayingField; // Assuming this is the correct import statement for your PlayingField class
import View.PrintPlayingField;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x, y;

            // Validate the width (x)
            do {
                System.out.println("Enter the width of the minesweeper x: ");
                x = scanner.nextInt();

                if (x < 1 || x > 50) {
                    System.out.println("The input value is not adaptable. Please enter a value between 1 and 50.");
                }
            } while (x < 1 || x > 50);

            // Validate the height (y)
            do {
                System.out.println("Enter the height of the minesweeper y: ");
                y = scanner.nextInt();

                if (y < 1 || y > 50) {
                    System.out.println("The input value is not adaptable. Please enter a value between 1 and 50");
                }
            } while (y < 1 || y > 50);

            // Validate the number of bombs
            int numberOfBombs;
            do {
                System.out.println("Enter the number of bombs: ");
                numberOfBombs = scanner.nextInt();

                if (numberOfBombs > x * y || numberOfBombs < 0) {
                    System.out.println("The input value is not adaptable. Please enter a valid value.");
                }
            } while (numberOfBombs > x * y || numberOfBombs < 0);

            // Create the PlayingField object with validated inputs
            PlayingField playingField = new PlayingField(x, y, numberOfBombs);
            PlayingField.generateBombs();
            PlayingField.generateTouchesBombs();
            System.out.println("game starts;");
            PrintPlayingField printPlayingField = new PrintPlayingField();
            while (!playingField.isLost()) {
                printPlayingField.printPlayingField();
                System.out.println("operation that you can choose");
                System.out.println("1=open, 2=flag");
                int x1 = 0;
                int y1 = 0;
                int operation = 0;
                String playAgain;
                System.out.println("which x position you are choosing: ");
                x1 = scanner.nextInt();
                System.out.println("which y position you are choosing: ");
                y1 = scanner.nextInt();
                System.out.println("which operation are you choosing: ");
                operation = scanner.nextInt();
                if (operation == 1) {
                    playingField.openCell(x1, y1);
                    playingField.openContiguosCells(x1, y1);
                } else if (operation == 2) {
                    playingField.addFlag(x1, y1);
                } else if (operation == 3) {
                    for (int i = 0; i < playingField.getCells().size(); i++) {
                        playingField.getCells().get(i).setOpen();
                    }
                    printPlayingField.printPlayingField();

                }
                if (playingField.getCells().get( x1 + x*y1) instanceof Bomb) {
                    for (int i = 0; i < playingField.getCells().size(); i++) {
                        playingField.getCells().get(i).setOpen();
                    }
                    printPlayingField.printPlayingField();
                    //playingField.setLostTrue();
                    System.out.println("game over");
                    System.out.println("play again? (yes/no): ");

                    playAgain = scanner.next();
                    if (!playAgain.equalsIgnoreCase("yes")) {
                        playingField.isLost();
                        break;

                    }

                }
            }
            // Close the scanner
            scanner.close();
        }
    }
}


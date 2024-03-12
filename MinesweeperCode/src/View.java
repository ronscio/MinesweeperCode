public class View {

    private int gameAreaSizeX;
    private int gameAreaSizeY;


    public void printGameArea() {
        // Print the top header for column numbers
        System.out.print("       "); // Adjust the initial spacing based on your layout
        for (int j = 1; j <= gameAreaSizeX; j++) {
            System.out.printf("%-3d", j); // Adjust spacing as needed to align with the grid
        }
        System.out.println(); // Move to the next line after printing the header

        // Now print each row
        for (int i = 0; i < gameAreaSizeY; i++) {
            System.out.printf("%-7d", i + 1); // Print the row number with proper alignment
            for (int j = 0; j < gameAreaSizeX; j++) {
                System.out.print("⏹  "); // Adjust the spacing as needed
            }
            System.out.println(); // Move to the next line after printing the row
        }
    }


    public void setGameAreaSizeX(int gameAreaSizeX) {
        this.gameAreaSizeX = gameAreaSizeX;
    }

    public void setGameAreaSizeY(int gameAreaSizeY) {
        this.gameAreaSizeY = gameAreaSizeY;
    }
}

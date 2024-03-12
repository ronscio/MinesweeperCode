public class Control {

    public void printGameArea(int gameAreaSizeX, int gameAreaSizeY) {
        if (gameAreaSizeX > 0 && gameAreaSizeY > 0) {
            View view = new View();
            view.setGameAreaSizeX(gameAreaSizeX);
            view.setGameAreaSizeY(gameAreaSizeY);
            view.printGameArea();

        } else {
            throw new IllegalArgumentException("Invalid game area size");
        }
    }

}

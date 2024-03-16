package Control;

public abstract class Cell {

    private int[] coordinates;
    private boolean open;
    private boolean flagged;

    public Cell(int x, int y) {
        coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        open = false;
        flagged = false;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public boolean getOpen() {
        return open;
    }

    public boolean getFlagged() {
        return flagged;
    }

    public void setOpen() {
        open = true;
    }

    public void setFlagged() {
         flagged = true;
    }
}

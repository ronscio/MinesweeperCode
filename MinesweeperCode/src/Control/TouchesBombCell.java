package Control;

public class TouchesBombCell extends Cell {
    private  int numberTouched;

    public TouchesBombCell(int x, int y, int numberTouched) {
        super(x, y);
        this.numberTouched = numberTouched;
    }

    public  int getTouchedCells() {
        return numberTouched;
    }

}

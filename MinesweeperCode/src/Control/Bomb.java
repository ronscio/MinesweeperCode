package Control;

public class Bomb extends Cell{

    private boolean exploded;


    public Bomb(int x, int y) {
        super(x, y);
        exploded = false;
    }

    public void setExploded() {
        exploded = true;
    }

}

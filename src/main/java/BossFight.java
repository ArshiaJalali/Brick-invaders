import processing.core.PApplet;
import processing.core.PImage;

public class BossFight implements ShowObject{
    private static PApplet p = Main.processing;
    PImage photo;
    private int x;
    private int y;

    public BossFight(){}

    public BossFight(int x, int y){
        this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\Bossfight-ufo.png");
        this.x = x;
        this.y = y;
    }


    @Override
    public void showObj() {
        p.image(photo, x, y, 500, 500);
    }

    //--------------------------------------------------------------------

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

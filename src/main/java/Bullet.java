import processing.core.PApplet;
import processing.core.PImage;

public class Bullet implements ShowObject {

    private int speedY;
    private int widthObj;
    private int heightObj;
    private float locatonX;
    private float locationY;
    private PImage photo;
    private static PApplet p = Main.processing;
    public Bullet(PImage photo,int speedY, int widthObj, int heightObj, float locatonX, float locationY) {
        this.speedY = speedY;
        this.widthObj = widthObj;
        this.heightObj = heightObj;
        this.locatonX = locatonX;
        this.locationY = locationY;
        this.photo = photo;
    }
    @Override
    public void showObj() {
        p.image(photo,locatonX,locationY,widthObj,heightObj);
    }
    public void moveObj(){
        locationY -= 2*speedY;
    }

    public int getWidthObj() {
        return widthObj;
    }

    public int getHeightObj() {
        return heightObj;
    }

    public float getLocatonX() {
        return locatonX;
    }

    public float getLocationY() {
        return locationY;
    }
}

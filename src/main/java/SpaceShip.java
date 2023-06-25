import processing.core.PApplet;
import processing.core.PImage;

public class SpaceShip implements ShowObject {
    private static PApplet p = Main.processing;
    PImage photo;
    int widthObj,heightObj;
    float locationX;
    float locationY;

    public SpaceShip(PImage photo,float locationX,float locationY, int widthObj, int heightObj) {
        this.photo = photo;
        this.locationX = locationX;
        this.widthObj = widthObj;
        this.heightObj = heightObj;
        this.locationY=locationY;
    }

    @Override
    public void showObj() {
        p.background(255);
        p.image(photo,p.mouseX-50,locationY,widthObj,heightObj);
    }

    public int getWidthObj() {
        return widthObj;
    }

    public int getHeightObj() {
        return heightObj;
    }

    public float getLocationX() {
        return locationX;
    }

    public float getLocationY() {
        return locationY;
    }
}

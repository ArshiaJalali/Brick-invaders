import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Blocks implements ShowObject {
    private static PApplet p = Main.processing;
    PImage photo;
    private int LocationX;
    private int LocationY = -10;
    private int level;
    public boolean checkfirst = true;
    private int widthObj;
    private int heightObj;
    private int shield;


    public Blocks() {
    }

    public Blocks(int LocationX, int LocationY, int level) {
        switch (level) {
            case 1:
                widthObj = 150;
                heightObj = 75;
                shield = 0;
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo1.png");
                p.image(photo, LocationX, LocationY, widthObj, heightObj);
                break;
            case 2:
                widthObj = 200;
                heightObj = 60;
                shield = 1;
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo2.png");
                p.image(photo, LocationX, LocationY, widthObj, heightObj);
                break;
            case 3:
                widthObj = 250;
                heightObj = 60;
                shield = 2;
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo3.png");
                p.image(photo, LocationX, LocationY, widthObj, heightObj);
                break;
            case 4:
                widthObj = 900;
                heightObj = 200;
                shield = 20;
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\Bossfight-ufo.png");
                p.image(photo, p.width/2, LocationY, widthObj, heightObj);
                break;
        }
        this.LocationX = LocationX;
        this.LocationY = LocationY;
        this.level = level;

    }

    public void makeBlocks() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Main.blocks.add(new Blocks(random.nextInt(300), LocationY, random.nextInt(1, 4)));
            LocationY -= 70;
            Main.blocks.add(new Blocks(random.nextInt(500 - 310 + 1) + 310, LocationY, random.nextInt(1, 4)));
            LocationY -= 70;
            Main.blocks.add(new Blocks(random.nextInt(700 - 510 + 1) + 510, LocationY, random.nextInt(1, 4)));
            LocationY -= 70;
            Main.blocks.add(new Blocks(random.nextInt(1100 - 800 + 1) + 800, LocationY, random.nextInt(1, 4)));
            LocationY -= 70;
            Main.limit+=4;
        }
    }

    @Override
    public void showObj() {
        //p.background(255);
        p.image(photo, getX(), getY(), widthObj, heightObj);
    }

    //--------------------------------------------------------------------------------
    public int getX() {
        return LocationX;
    }

    public void setX(int x) {
        this.LocationX = x;
    }

    public int getY() {
        return LocationY;
    }

    public void setY(int y) {
        this.LocationY = y;
    }

    public int getWidthObj() {
        return widthObj;
    }

    public void setWidthObj(int widthObj) {
        this.widthObj = widthObj;
    }

    public int getHeightObj() {
        return heightObj;
    }

    public void setHeightObj(int heightObj) {
        this.heightObj = heightObj;
    }

    public int getLevel() {
        return level;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}
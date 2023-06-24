//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet processing;
    PImage photo;
    ArrayList<ShowObject> showObjects = new ArrayList();

    public Main() {
    }

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void setup() {
        processing = this;
        this.photo = this.loadImage("D:\\Processing\\project\\Brick-invaders\\Brick-invaders\\Brick-invaders\\src\\main\\java\\spaceship.png");
        SpaceShip spaceShip = new SpaceShip(this.photo, (float)(this.height - 150), 100, 150);
        this.showObjects.add(spaceShip);
    }

    public void settings() {
        this.fullScreen();
    }

    public void draw() {
        Iterator var1 = this.showObjects.iterator();
        if (var1.hasNext()) {
            ShowObject s = (ShowObject)var1.next();
            s.showObj();
        }

    }
}

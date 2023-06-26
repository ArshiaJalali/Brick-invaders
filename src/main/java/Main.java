//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet processing;
    PImage photo;
    ArrayList<ShowObject> showObjects = new ArrayList();
    public static ArrayList<Blocks> blocks = new ArrayList();
    public Blocks block ;

    public Main() {
    }

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void setup() {
        processing = this;
        this.photo = this.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\spaceship.png");
        SpaceShip spaceShip = new SpaceShip(this.photo, (float)(this.height - 150), 100, 150);
        this.showObjects.add(spaceShip);

        block = new Blocks();
        block.makeBlocks();
    }

    public void settings() {
        this.fullScreen();
    }

    public void draw() {
        background(255);
        Iterator var1 = this.showObjects.iterator();
        if (var1.hasNext()) {
            ShowObject s = (ShowObject)var1.next();
            s.showObj();
        }

        for (Blocks b : blocks) {
            b.showObj();
        }
        movedBlocks();
    }

    public void movedBlocks(){
        Random random =new Random();
        for (int i = 0; i < blocks.size(); i++) {
            Blocks b = blocks.get(i);
            b.setY(b.getY()+5);
            if ( b.checkfirst && b.getY()>height/2 ) {
                Main.blocks.add(new Blocks(random.nextInt(width-100), -100, random.nextInt(3)));

                b.checkfirst = false;
            }
        }
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet processing;
    PImage spaceShipPhoto;
    PImage bulletPhoto;
    ArrayList<ShowObject> showObjects = new ArrayList();
    SpaceShip spaceShip;
    Bullet bullet;
    ArrayList<Bullet> bullets = new ArrayList<>();

    public static ArrayList<Blocks> blocks = new ArrayList();
    public Blocks block;


    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void setup() {
        processing = this;
        this.spaceShipPhoto = this.loadImage("D:\\Processing\\project\\Brick-invaders\\src\\main\\java\\spaceship.png");
        this.bulletPhoto = this.loadImage("D:\\Processing\\project\\Brick-invaders\\src\\main\\java\\bullet.png");
        bullet = new Bullet(bulletPhoto, 0, 0, 0, 0, 0);
        block = new Blocks();
        block.makeBlocks();
    }

    public void settings() {
        this.fullScreen();
    }

    public void draw() {
        background(255);
        // create and show spaceShip
        SpaceShip spaceShip1 = new SpaceShip(this.spaceShipPhoto, mouseX, (float) (this.height - 150), 100, 150);
        spaceShip = spaceShip1;
        spaceShip.showObj();
        // show and move bullet
        for (Bullet b : bullets) {
            b.showObj();
            b.moveObj();

        }
        for (Blocks b : blocks) {
            b.showObj();
        }
        movedBlocks();
    }

    @Override
    public void mousePressed() {
        Bullet bullet1 = new Bullet(bulletPhoto, 4, 50, 60, mouseX - 25, spaceShip.getLocationY() - 55);
        bullets.add(bullet1);
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
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
    public static int limit = 0;
    public boolean isOk = true;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void setup() {
        processing = this;
        background(0);
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
        background(0);
        if (isOk) {
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
            shootingAtBlock();
            movedBlocks();
            crushed();
        }else {
            background(200);
            fill(240, 0, 10);
            textSize(50);
            text("GAME OVER", 40, 300);
        }
    }

    @Override
    public void mousePressed() {
        Bullet bullet1 = new Bullet(bulletPhoto, 4, 50, 60, mouseX - 25, spaceShip.getLocationY() - 55);
        bullets.add(bullet1);
    }

    public void movedBlocks() {
        Random random = new Random();
        for (int i = 0; i < blocks.size(); i++) {
            Blocks b = blocks.get(i);
            b.setY(b.getY() + 1);
            if (b.getY() > height) {
                blocks.remove(b);
                i--;
            }
            if (b.checkfirst && b.getY() > height / 2) {
                if (limit < 50) {
                    Main.blocks.add(new Blocks(random.nextInt(width - 100), -100, random.nextInt(1, 3)));
                    b.checkfirst = false;
                    limit++;
                }
            }
        }
    }

    public void shootingAtBlock() {
        Random random = new Random();
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < blocks.size(); j++) {
                Bullet bullet = bullets.get(i);
                Blocks block = blocks.get(j);
                if (bullet.getLocatonX() > block.getX() - bullet.getWidthObj() && bullet.getLocatonX() < block.getX() + block.getWidthObj() && bullet.getLocationY() > block.getY() - bullet.getHeightObj() && bullet.getLocationY() < block.getY() + block.getHeightObj()) {
                    System.out.println(block.getShield());
                    if (block.getShield() == 0) {
                        if (limit<50) {
                            blocks.remove(block);
                            Main.blocks.add(new Blocks(random.nextInt(width - 100), -150, random.nextInt(1, 4)));
                        }
                        i--;
                    } else {
                        block.setShield(block.getShield() - 1);
                    }
                    bullets.remove(bullet);
                    break;
                }
            }
        }
    }

    public void crushed() {
        for (int i = 0; i < blocks.size(); i++) {
            Blocks block = blocks.get(i);
            if (block.getY() + block.getHeightObj() >= height - 145 && spaceShip.getLocationX() > block.getX() - bullet.getWidthObj() && spaceShip.getLocationX() < block.getX() + block.getWidthObj()) {
                isOk=false;
            }
        }
    }
}

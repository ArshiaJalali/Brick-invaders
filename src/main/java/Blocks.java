import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Blocks implements ShowObject{
    private static PApplet p = Main.processing;
    PImage photo;
    private int x;
    private int y = -10;
    /*private int dy;*/
    private int level;
    public boolean checkfirst = true;

    public Blocks(){};

    public Blocks(int x, int y, int level) {
        switch (level){
            case 1:
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo1.png");
                p.image(photo,x,y,100,100);
                break;
            case 2:
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo2.png");
                p.image(photo,x,y,100,100);
                break;
            case 3:
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo3.png");
                p.image(photo,x,y,100,100);
                break;
            default:
                this.photo = p.loadImage("C:\\Users\\MiTi\\Desktop\\Uni\\java\\Brick-invaders\\src\\main\\java\\ufo3.png");
                p.image(photo,x,y,100,100);
                break;
        }

        this.x = x;
        this.y = y;
        /*this.dy = dy;*/
        this.level = level;
    }

    public void makeBlocks(){
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Main.blocks.add(new Blocks(random.nextInt(300), y, random.nextInt(3)));
            y-=50;
            Main.blocks.add(new Blocks(random.nextInt(500 - 310+1)+310, y, random.nextInt(3)));
            y-=50;
            Main.blocks.add(new Blocks( random.nextInt(700 - 510+1)+510, y, random.nextInt(3)));
            y-=50;
            Main.blocks.add(new Blocks(random.nextInt(1100 - 800+1)+800, y, random.nextInt(3)));
            y-=50;
        }
    }

    @Override
    public void showObj() {
        //p.background(255);
        p.image(photo, getX(), getY(),75,75);
    }

    //--------------------------------------------------------------------------------
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

    /*public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }*/
}

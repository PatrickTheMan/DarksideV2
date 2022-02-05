import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Set;

public class Player {

    private BufferedImage[] walkingLeft;
    private BufferedImage[] walkingRight;
    private BufferedImage[] standing;

    private Animation walkLeftAnimation;
    private Animation walkRightAnimation;
    private Animation standingAnimation;

    public Animation animation;

    enum characterSelection{
        Guy
    }

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

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int x;
    private int y;
    private int HP;
    private int speed;
    private int width;
    private int height;
    Random r = new Random();


    public Player(int HP, int speed, int width, int height, characterSelection cs){

        this.x= GameEngine.settings.getScreenWidth()/2-width/2;
        this.y= GameEngine.settings.getScreenHeight()/2-height/2;

        System.out.println("Player x: "+this.x+" / Player y: "+this.y);

        this.HP = HP;
        this.speed = speed;
        this.width = width;
        this.height = height;

        // Load Character HERE

    }

    public Graphics2D getPlayerBox(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);

        g2.fillRect(this.x,this.y,width,height);

        return g2;
    }














    public void loadAnimations(){

        // Load the sprite
        Sprite.loadSprite("");

        // Images for each animation
        //BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)}; // Gets the upper left images of my sprite sheet
        //BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2)};
        //BufferedImage[] standing = {Sprite.getSprite(1, 0)};

        BufferedImage[] standing = {Sprite.getSprite(0, 2)};

        // These are animation states
        //Animation walkLeftAnimation = new Animation(walkingLeft, 10);
        //Animation walkRightAnimation = new Animation(walkingRight, 10);
        //Animation standingAnimation = new Animation(standing, 10);

        Animation standingAnimation = new Animation(standing, 10);

        // This is the actual animation
        Animation animation = standingAnimation;
    }





}

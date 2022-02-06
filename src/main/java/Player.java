import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {

    //region [Getters & Setters]
    public boolean isPlayerMoving() {
        return playerMoving;
    }

    public void setPlayerMoving(boolean playerMoving) {
        this.playerMoving = playerMoving;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
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
    //endregion

    //region [Variables]

    enum Facing {
        left,
        right
    }

    Facing facing = Facing.left;

    private int x;
    private int y;
    private int HP;
    private int speed;
    private int width;
    private int height;
    Random r = new Random();

    private int amountPicWidth;
    private int amountPicHeight;
    private int singlePicWidth;
    private int singlePicHeight;

    private double spriteTimer=0;
    private double spriteMaxTimer;
    private int spriteNum=0;
    private boolean playerMoving=false;
    //endregion

    //region [Objects]
    Sprite playerSpriteLeft;
    Sprite playerSpriteRight;
    //endregion

    //region [Constructor]
    public Player(String playerType,int singlePicWidth, int singlePicHeight,int amountPicWidth,int amountPicHeight,double delay,int HP, int speed, int width, int height){

        this.x= GameEngine.settings.getScreenWidth()/2-width/2;
        this.y= GameEngine.settings.getScreenHeight()/2-height/2;

        System.out.println("Player x: "+this.x+" / Player y: "+this.y);

        this.HP = HP;
        this.speed = speed;
        this.width = width;
        this.height = height;

        this.amountPicHeight = amountPicHeight;
        this.amountPicWidth = amountPicWidth;
        this.singlePicHeight = singlePicHeight;
        this.singlePicWidth = singlePicWidth;

        this.spriteMaxTimer=delay;

        this.playerSpriteLeft = new Sprite(playerType+"_Left",singlePicWidth,singlePicHeight,amountPicWidth,amountPicHeight);
        this.playerSpriteRight = new Sprite(playerType+"_Right",singlePicWidth,singlePicHeight,amountPicWidth,amountPicHeight);
    }
    //endregion

    //region [Graphics]
    public Graphics2D getPlayerBox(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);

        g2.fillRect(this.x,this.y,width,height);

        return g2;
    }

    public Graphics2D getPlayerSprite(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        if (playerMoving){

            spriteTimer++;

            if (spriteTimer == spriteMaxTimer*10){

                spriteNum++;
                spriteTimer=0;

                if (spriteNum==amountPicHeight*amountPicWidth){
                    spriteNum=0;
                }
            }

            playerMoving=false;
        }

        if (facing.equals(Facing.left)){
            g2.drawImage(playerSpriteLeft.collectionSprites[spriteNum], x,y,width,height,null);
        } else {
            g2.drawImage(playerSpriteRight.collectionSprites[spriteNum], x,y,width,height,null);
        }

        return g2;
    }
    //endregion

}

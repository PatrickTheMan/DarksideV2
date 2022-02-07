import java.awt.*;
import java.util.Random;

public class Enemy {

    //region [Getters & Setters]
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
    //endregion

    //region [Variables]
    private int x, y, HP, speed, width,height;

    private double spriteTimer=0;
    private double spriteMaxTimer;
    private int spriteNum=0;

    private int amountPicWidth;
    private int amountPicHeight;
    private int singlePicWidth;
    private int singlePicHeight;

    private enum Facing {
        left,
        right
    }

    private Facing facing = Facing.left;
    //endregion

    //region [Objects]
    Sprite enemySpriteLeft;
    Sprite enemySpriteRight;
    //endregion

    //region [Constructor]
    public Enemy (String enemyType,int singlePicWidth, int singlePicHeight, int amountPicWidth, int amountPicHeight,double delay,int HP, int speed,int x, int y ,int width, int height){

        this.x = x-width/2;
        this.y = y-height/2;

        System.out.println("enemy x: "+this.x+" / enemy y: "+this.y);

        this.HP = HP;
        this.speed = speed;
        this.width = width;
        this.height = height;

        this.amountPicWidth = amountPicWidth;
        this.amountPicHeight = amountPicHeight;
        this.singlePicWidth = singlePicWidth;
        this.singlePicHeight = singlePicHeight;

        this.spriteMaxTimer = delay;

        this.enemySpriteLeft = new Sprite(enemyType+"_Left",singlePicWidth,singlePicHeight,amountPicWidth,amountPicHeight);
        this.enemySpriteRight = new Sprite(enemyType+"_Right",singlePicWidth,singlePicHeight,amountPicWidth,amountPicHeight);
    }
    //endregion

    //region [Graphics]
    public Graphics2D getEnemyBox(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.RED);

        g2.fillRect(this.x,this.y,width,height);

        return g2;
    }

    public Graphics2D getEnemySprite(Graphics g, Player player){

        Graphics2D g2 = (Graphics2D)g;

        spriteTimer++;

        if (spriteTimer == spriteMaxTimer*10){
            spriteNum++;
            spriteTimer=0;

            if (spriteNum==amountPicHeight*amountPicWidth){
                spriteNum=0;
            }
        }

        if (facing.equals(Facing.left)){
            g2.drawImage(enemySpriteLeft.collectionSprites[spriteNum], x,y,GameEngine.settings.getTileSize(),GameEngine.settings.getTileSize(),null);
        } else {
            g2.drawImage(enemySpriteRight.collectionSprites[spriteNum], x,y,GameEngine.settings.getTileSize(),GameEngine.settings.getTileSize(),null);
        }

        return g2;
    }
    //endregion

    //region [AI]
    public void enemyAIUpdate(Player player){

        double playerLocationX = GameEngine.settings.getScreenWidth()/2-player.getWidth()/2;
        double playerLocationY = GameEngine.settings.getScreenHeight()/2-player.getWidth()/2;

        if (this.x < playerLocationX){
            this.facing = Facing.right;
            this.x +=this.speed;
        } else if (this.x > playerLocationX){
            this.facing = Facing.left;
            this.x -=this.speed;
        }

        if (this.y < playerLocationY){
            this.y +=this.speed;
        } else if (this.y > playerLocationY){
            this.y -=this.speed;
        }


    }
    //endregion

    //region [Boolean methods]
    public boolean isDead(){
        if (this.HP>0){
            return false;
        } else {
            return true;
        }
    }
    //endregion

}

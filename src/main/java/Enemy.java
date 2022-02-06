import java.awt.*;
import java.util.Random;

public class Enemy {

    //region [Variables]
    int x, y, HP, speed, width,height;
    Random r = new Random();

    double spriteTimer=0;
    double spriteMaxTimer;
    int spriteNum=0;

    int amountPicWidth;
    int amountPicHeight;
    int singlePicWidth;
    int singlePicHeight;

    enum Facing {
        left,
        right
    }

    Enemy.Facing facing = Enemy.Facing.left;
    //endregion

    //region [Objects]
    Sprite enemySpriteLeft;
    Sprite enemySpriteRight;
    //endregion

    //region [Constructor]
    public Enemy (String enemyType,int singlePicWidth, int singlePicHeight, int amountPicWidth, int amountPicHeight,double delay,int HP, int speed, int width, int height){

        // Can spawn random in the area around the screen
        this.x = r.nextInt(0,GameEngine.settings.getScreenWidth()-64);
        this.y = r.nextInt(0,GameEngine.settings.getScreenHeight()-64);

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
        this.enemySpriteRight = new Sprite(enemyType+"_Left",singlePicWidth,singlePicHeight,amountPicWidth,amountPicHeight);
    }
    //endregion

    //region [Graphics]
    public Graphics2D getEnemyBox(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.RED);

        g2.fillRect(this.x,this.y,width,height);

        return g2;
    }

    public Graphics2D getEnemySprite(Graphics g){

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

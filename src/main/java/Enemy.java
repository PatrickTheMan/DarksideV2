import java.awt.*;
import java.util.Random;

public class Enemy {

    int x, y, HP, speed, width,height;
    Random r = new Random();

    public Enemy (int HP, int speed, int width, int height){

        // Can spawn random in the area around the screen
        this.x = r.nextInt(0,GameEngine.settings.getScreenWidth()-64);
        this.y = r.nextInt(0,GameEngine.settings.getScreenHeight()-64);



        // Can spawn in all 4 corners
        /*
        if (r.nextInt(2)==1){
            this.x=0;
        } else {
            this.x=GameEngine.settings.getScreenWidth()-64;
        }

        if (r.nextInt(2)==1){
            this.y=0;
        } else {
            this.y=GameEngine.settings.getScreenHeight()-64;
        }

         */

        System.out.println("enemy x: "+this.x+" / enemy y: "+this.y);

        this.HP = HP;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public Graphics2D getEnemyBox(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.RED);

        g2.fillRect(this.x,this.y,width,height);

        return g2;
    }

    public boolean isDead(){
        if (this.HP>0){
            return false;
        } else {
            return true;
        }
    }

}
